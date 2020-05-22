import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class User implements Serializable{
    private static final long serialVersionUID = -7667553477247791348L;
    private int id;
    private String name;    
    private String category;
    private static String db_table = "db table name of this class";

    public User(){

    }
    public User(int id, String name, String cat) {
        super();
        this.id = id;
        this.name = name;
        this.category = cat;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public static List<User> getListByCategory(DBM dbm, String cid, boolean close) throws Exception{
        List<User> list            = new ArrayList<User>();
        PreparedStatement preState = null;
        ResultSet resultSet        = null;
        try {
            if( dbm == null ){
                dbm = new DBM();
            }
            String sql = "SELECT * FROM "+db_table+" WHERE _CATEGORY_ID=?";
            preState   = dbm.initConnection().prepareStatement(sql); 
            preState.setString(1, cid);
            resultSet  = preState.executeQuery();
            while (resultSet.next()) {
                list.add( new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)) );                
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if( preState != null )
                preState.close();
            if( close && dbm.connection != null )
                dbm.connection.close();         
        }
        return list;
    }

}