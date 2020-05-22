CallableStatement stmt = conn.prepareCall("begin myprocedure(?,?); end;");
stmt.setString(1, "foo");
stmt.registerOutParameter(2, java.sql.Types.ARRAY, "OUTPUTONESQLTYPE"); // YOUR ARRAY TYPE (TO MATCH THE API OUTPUT), NOT OBJECT
stmt.execute();
Array arr = stmt.getArray (2);
Map map = conn.getTypeMap();
map.put("TABLEONEEXAMPLE", Class.forName("TestArr")); // YOUR OBJECT TYPE, NOT ARRAY.
Object[] values = (Object[]) arr.getArray();
for (int i=0; i < values.length; i++)
{
  TestArr a = (TestArr)values[i];
  System.out.println("somethingOne: " + a.attrOne);
  System.out.println("somethingTwo: " + a.attrTwo);
}