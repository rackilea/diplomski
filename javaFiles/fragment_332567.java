class Vehicle { 
    public void drive() { 
        ....
    }
}
class ConvertibleVehicle extends Vehicle { 
         // specialized version may override base operation or may not.
        public void drive() { 
          ... 
         }

         public void foldRoof() { // specialized operation 
             ...
         }
 }