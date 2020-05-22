public class MyObject01 implements SQLData {
   private String value;
   private MyObject02[] details; // do note that details is a java array
   // ... also added getters and setters for these two properties

   private Array detailsArray;

   public void setupArrays(oracle.jdbc.OracleConnection oconn)
      throws SQLException
   {
       detailsArrays = oconn.createARRAY(MyObject02.ORACLE_OBJECT_ARRAY_NAME, getDetails());
       // MyObject02.ORACLE_OBJECT_ARRAY_NAME must be the name of the oracle "table of" type name
       // Also note that in Oracle you can't use JDBC's default createArray
       // since it's not supported. That's why you need to get a OracleConnection
       // instance here. 
   }       

   @Override
   public void writeSQL(Stream stream) throws SQLException {
       stream.writeString(getValue());
       stream.writeArray(detailsArray); // that's it
   }

   @Override
   public void readSQL(Stream stream) throws SQLException {
       setValue(stream.readString());
       Array array = stream.readArray();
       if (array != null) {
           setDetails((MyObject02[])array.getArray());
       }
   }