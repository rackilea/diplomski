HashMap<String, String> myObjectStoreTwo = new HashMap<String, String>();

String[] directReports2 = new String[]{"Natraj G", "Kalyan", "Mahitha"}; 

myObjectStoreTwo.put("emp_id", "123"); 
myObjectStoreTwo.put("emp_name", "Raf"); 
myObjectStoreTwo.put("salary", "222");

//Converts array to comma separated String 
myObjectStoreTwo.put("directReports",Arrays.toString(directReports2));