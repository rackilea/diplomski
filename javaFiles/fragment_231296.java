/*Here we do the following steps
*  1. create the data
*  2. convert data to Json String using GSON
*  3. JSon String is used to populate the data bean using GSON.
*
*  Integers will be used as the key.
*/ 
public class CreateAccessGSON()
{
    public static void main(String[] args)
    {

         Gson gson = new Gson(); //instantiate gson here.

         //Creating the Data Object.
         HashMap<Integer,AdminBean> tmpAdminMap = new HashMap<Integer,AdminBean>();

         AdminBean adminOne1 = new AdminBean();
         adminOne1.setName("Joe");

         tmpAdminMap.put(1,adminOne1);   // key is an Integer 1

         AdminBean adminOne2 = new AdminBean();
         adminOne2.setName("Blow");

         tmpAdminMap.put(2,adminOne2);   // key is an Integer 2

         //Set the value of the Map.
         DataObjectBean dataObjectBean = new DataObjectBean();
         dataObjectBean.setAdminMap(tmpAdminMap);

         String jsonString = gson.toJson(dataObjectBean);

         System.out.println(jsonString ); // print the Json String.
          //Output will be as follows
         /*
           {
             "adminMap" : 
                    { 
                        "1" : {"name":"Joe"} ,
                        "2" : {"name":"Blow"}
                    }
           }
         */




         // Code to Convert Json String to the Associated object.
          DataObjectBean accessDataObjectBean = gson.fromJson(jsonString ,DataObjectBean);
          HashMap<Integer,AdminBean> retrieveAdminMap = accessDataObjectBean.getAdminMap();
          System.out.println(retrieveAdminMap.get(1).getName()); // Joe
          System.out.println(retrieveAdminMap.get(2).getName()); // Blow

          //get number of keys, we use the hashmap size.
          System.out.println("Num of keys : " + retrieveAdminMap.size()); // Num of keys : 2

          // You can use the Java Iterator to access each key and their values
          Set<Integer> setKey = retrieveAdminMap.keySet();
          for( Integer keys : setKey )
          {
                AdminBean eachAdmin = retrieveAdminMap.get(keys);
                System.out.println(eachAdmin.getName()); 
          }
    }
} 



//This class will store the Admin data. You can have more nested classes here.
// This class can further have more maps.
public class AdminBean
{
    private String name = "";

    public String getName()
    { 
        return name;
    }

    public String setName(String name)
    {
        this.name = name;
    }
}

// This main Java Bean which will be used to generate the JSON.
// Since we need as Integer as key, we use the HashMap to store it.
// HashMaps will allow storing unlimited Integers.
public class DataObjectBean{
    private HashMap<Integer,AdminBean> adminMap = new HashMap<Integer,AdminBean>();
    public String getAdminMap ()
    { 
        return adminMap ;
    }

    public String setAdminMap (String adminMap )
    {
        this.name = adminMap ;
    }
}