class VehicleDB {

   ArrayList<Vehicle> db = new ArrayList<Vehicle>();

   void addVehicle(Vehicle c){
      db.add(c);
   }

   void print(){
      System.out.println("=== Vehicle Data Base ===");
      for(Vehicle v: db){
         v.print();
      }
   }
}