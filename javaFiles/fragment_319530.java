ArrayDescriptor ageCollection = ArrayDescriptor.createDescriptor("AGE", conn);   
ArrayDescriptor weightCollection = ArrayDescriptor.createDescriptor("WEIGHT", conn); 
ArrayDescriptor nameCollection = ArrayDescriptor.createDescriptor("NAME", conn);   
int[] ageArray = new int[50000];  
int[] weightArray = new int[50000];  
String[] nameArray = new String[50000];  
for(int i = 0; i <50000;i++)  
{  
    ageArray[i]=i;  
    weightArray[i]=i;
    nameArray[i] = "Test";
}  
ARRAY oraAge = new ARRAY(ageCollection,conn,ageArray);  
ARRAY oraWeight = new ARRAY(weightCollection,conn,weightArray);  
ARRAY oraName = new ARRAY(nameCollection,conn,nameArray);    

CallableStatement statement = conn.prepareCall("{CALL insert_new_cat(?,?,?)}";   

statement.setObject(1,oraAge);
statement.setObject(2,oraWeight);  
statement.setObject(3,oraName);  
statement.execute();  
conn.commit();