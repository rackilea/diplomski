public class CompanyData{
     private String name, address, phone;
     private int size;
     public CompanyData(JsonObject jo){
         name = jo.getString("name");
         address = jo.getString("address");
         phone = jo.getString("phone");
         size = jo.getInt("size");
     }
     // put a bunch of get methods here...
     // getName(), getAddress(), etc.
 }