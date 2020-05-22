import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The <code>DatabaseObject</code> represents a single row of data from a 
 * specific table within a database.
 * <p>
 * The object should implement getters and setters for each column, and is 
 * responsible for registering the correct table name and column names, as 
 * well as default values for those columns, in case a default value is 
 * not supported by the database table.
 * <p>
 * The <code>DatabaseObject</code> works with key-value pairs as an 
 * extended <code>LinkedHashMap</code>. It defines one property, 
 * <code>DatabaseObject.ROW_ID</code> which represents the unique 
 * identifier column for a table row. This column should always be an 
 * integer value. (Future implementations may allow for long values, but 
 * <code>Integer.MAX_VALUE</code> is well suited for most databases as a maximum 
 * row count per table).
 * <p>
 * The key and value pairs should be accessed by implementing getter and 
 * setter methods, not by the get and put methods provided by the 
 * <code>LinkedHashMap</code>. This is to ensure proper <code>Class</code> 
 * type casting for each value.
 * <p>
 * A <code>DatabaseObject</code> itself is also an extension of a 
 * <code>JsonObject</code>, and <code>toString()</code> may be called on 
 * it to provide a JSON notated <code>DatabaseObject</code>.
 * <p>
 * When using JSON however, keep in mind that the keys may not correspond 
 * exactly with the table column names, even though that is the recommendation. 
 * The <code>DatabaseObject</code> should be converted back into its 
 * implementing object form and saved when using web services.
 * <p>
 * The parameter <code>T</code> should be set to the class of the implementing 
 * <code>DatabaseObject</code>. This will allow proper class casting when 
 * returning instances of the implementation, such as in the <code>load()</code> 
 * methods.
 * @param <T> the type of <code>DatabaseObject</code>
 * @author Andrew
 */
public abstract class DatabaseObject<T extends DatabaseObject> 
        extends JsonObject<Object> implements Cloneable{

    /**The property for the row ID*/
    public final static String ROW_ID = "rowId";

    /**
     * Creates a new empty <code>DatabaseObject</code>.
     */
    public DatabaseObject() {

    }


    /**
     * {@inheritDoc }
     * <p>
     * This get method will additionally check the <code>Class</code> of 
     * the returned value and cast it if it is a <code>String</code> but
     * matches another <code>Class</code> type such as a number.
     * @see #doGet(java.lang.String, boolean) 
     */
    @Override
    public Object get(Object key) {
        //From here you can specify additional requirements before retrieving a value, such as class checking
        //This is optional of course, and doGet() calls super.get()
        return doGet(String.valueOf(key), true);
    }

    /**
     * {@inheritDoc }
     * <p>
     * This get method will additionally check the <code>Class</code> of 
     * the given value and cast it if it is a <code>String</code> but
     * matches another <code>Class</code> type such as a number.
     * @see #doPut(java.lang.String, java.lang.Object, boolean) 
     */
    @Override
    public Object put(String key, Object value) {
        //Like doGet(), doPut() goes through additional checks before returning a value
        return doPut(key, value, true);
    }

    //Here are some example getter/setter methods
    //DatabaseObject provides an implementation for the row ID column by default

    /**
     * Retrieves the row ID of this <code>DatabaseObject</code>.
     * <p>
     * If the row ID could not be found, -1 will be returned. Note that 
     * a -1 <i>may</i> indicate a new <code>DatabaseObject</code>, but it 
     * does not always, since not all <code>Databases</code> support 
     * retrieving the last inserted ID.
     * <p>
     * While the column name might not correspond to "rowId", this 
     * method uses the <code>DatabaseObject.ROW_ID</code> property. All 
     * objects must have a unique identifier. The name of the column 
     * should be registered in the constructor of the object.
     * @return the <code>DatabaseObject's</code> row ID, or -1 if it is not set
     */
    public int getRowId() {
        //getProperty(), while not included, simply returns a default specified value 
        //if a value has not been set
        return getProperty(ROW_ID, -1);
    }
    /**
     * Sets the row ID of this <code>DatabaseObject</code>.
     * <p>
     * <b>Note: this method should rarely be used in implementation!</b>
     * <p>
     * The <code>DatabaseObject</code> will automatically set its row ID when 
     * retrieving information from a <code>Database</code>. If the row ID 
     * is forcibly overriden, this could overwrite another existing row entry 
     * in the database table.
     * @param rowId the row ID of the <code>DatabaseObject</code>
     */
    public void setRowId(int rowId) {
        //And again, setProperty() specifies some additional conditions before 
        //setting a key-value pair, but its not needed for this example
        setProperty(ROW_ID, rowId);
    }


    //This is where your question will be answered!!

    //Since everything in a DatabaseObject is set as a key-value pair in a 
    //Map, we don't have to use reflection to look up values for a 
    //specific object. We can just iterate over the key-value entries

    public synchronized void save(Database database) throws SaveException {
        StringBuilder sql = new StringBuilder();
        //You would need to check how you want to save this, let's assume it's 
        //an UPDATE
        sql.append("UPDATE ").append(getTableName()).append(" SET ");

        Iterator<String, Object> iter = entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Object> entry = iter.next();
            String property = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof DatabaseObject) {
                ((DatabaseObject)value).save();
            }
            else if (value instanceof Collection) {
                for (Object v : (Collection)value) {
                    ((DatabaseObject)value).save();
                }
            }
            //However many other checks you want, such as Maps, Arrays, etc
            else {              
                sql.append(property); //Assuming the property equals the column name
                sql.append("='").append(value).append("'");             
            }
            if (iter.hasNext()) {
                sql.append(", ");
            }
        }


        //getIdColumn() would retrieve which column is being used as the identifier
        sql.append("WHERE ").append(getIdColumn()).append("=").append(getRowId());


        //Finally, take our SQL string and save the value to the Database

        //For me, I could simply call database.update(sql), and
        //the abstracted Database object would determine how to 
        //send that information via HTTP as a JSON object

        //Of course, your save() method would vary greatly, but this is just a quick
        //and dirty example of how you can iterate over a Map's 
        //key-value pairs and take into account values that are 
        //DatabaseObjects themselves that need to be saved, or 
        //a Collection of DatabaseObjects that need to be saved
    }

    /**
     * Retrieves the name of the database table that this 
     * <code>DatabaseObject</code> pulls its information from.
     * <p>
     * It is recommended to declare a final and static class variable that 
     * signifies the table name to reduce resource usage.
     * @return name of the database table
     */
    public abstract String getTableName();
}