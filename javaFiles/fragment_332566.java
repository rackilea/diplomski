class Vehicle { 
     public abstract void drive();
}

class ConvertibleVehicle { 
     public void drive() { 
         this.foldRoof();
         .... // drive 
     }
     private void foldRoof() { 
         ....
     }
 }