//oracle.sql.ARRAY we will use as out parameter from the package
//and will store pl/sql table
ARRAY message_display = null; 

//ArrayList to store object of type struct 
ArrayList arow= new ArrayList();

//StructDescriptor >> use to describe pl/sql object
//type in java.
StructDescriptor voRowStruct = null; 

//ArrayDescriptor >> Use to describe pl/sql table
//as Array of objects in java
ArrayDescriptor arrydesc = null;

//Input array to pl/sql procedure
ARRAY p_message_list = null;

//Oracle callable statement used to execute procedure
OracleCallableStatement cStmt=null;

try
{
//initializing object types in java.
voRowStruct = StructDescriptor.createDescriptor("RECTYPE",conn); 
arrydesc = ArrayDescriptor.createDescriptor("RECTAB",conn);
}

catch (Exception e)
{
throw OAException.wrapperException(e);
}

for(XXVORowImpl row = (XXVORowImpl)XXVO.first(); 
row!=null;
row = (XXVORowImpl)XXVO.next())
{
//We have made this method to create struct arraylist
// from which we will make ARRAY
//the reason being in java ARRAY length cannot be dynamic
//see the method defination below.
populateObjectArraylist(row,voRowStruct,arow); 
}

//make array from arraylist
STRUCT [] obRows= new STRUCT[arow.size()];
for(int i=0;i < arow.size();i++)
{
obRows[i]=(STRUCT)arow.get(i);
}

try 
{
p_message_list = new ARRAY(arrydesc,conn,obRows); 
}
catch (Exception e)
{
throw OAException.wrapperException(e);
}

//jdbc code to execute pl/sql procedure 
try
{
cStmt
=(OracleCallableStatement)conn.prepareCall("{CALL ioStructArray.testproc(:1,:2)}"); 
cStmt.setArray(1,p_message_list);
cStmt.registerOutParameter(2,OracleTypes.ARRAY,"RECTAB"); 
cStmt.execute();

//getting Array back
message_display = cStmt.getARRAY(2);
//Getting sql data types in oracle.sql.datum array
//which will typecast the object types
Datum[] arrMessage = message_display.getOracleArray();

//getting data and printing it
for (int i = 0; i < arrMessage.length; i++)
{ 
oracle.sql.STRUCT os = (oracle.sql.STRUCT)arrMessage[i];
Object[] a = os.getAttributes(); 
System.out.println("a [0 ] >>attribute1=" + a[0]); 
System.out.println("a [1 ] >>attribute2=" + a[1]);
System.out.println("a [2 ] >>attribute3=" + a[2]);