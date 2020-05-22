public class LocationData {
     //Name these appropriately! I don't know what they're for.
     private Location location;
     private String string1;
     private int num1;
     private String string2;
     private int num2;
     private String string3;
     private String string4;

     //Constructor
     public LocationData(Location loc, String s1, int n1, String s2, int n2, String s3, String s4) {
         location = loc;
         //And so on for each field
         ...
     }

     //One pair of methods for each field
     public Location getLocation() {
         return location;
     }
     public void setLocation(Location loc) {
         location = loc;
     }