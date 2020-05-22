if (vehicles[1].type.equals(VehicleType.bicycle)) {
        System.out.println(vehicles[1]);
    }

   public class Bicycle extends Vehicle { 

       @Override
       public String toString() { 
          return this.saddles;
       }
   }