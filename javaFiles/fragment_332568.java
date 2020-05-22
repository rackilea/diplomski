// Client ( base handler ) 
public class FleetHandler { 
     public void handle( Vehicle [] fleet ) { 
           for( Vehicle v : fleet ) {  
               v.drive();
            }
     }
}

// Specialized client ( sophisticate handler that is )  
 public class RoofAwareFleetHandler extends FleetHandler { 
      public void handle( Vehicle [] fleet ) { 
           for( Vehicle v : fleet ) { 
              // there are two options.
              // either all vehicles are ConvertibleVehicles (risky) then
              ((ConvertibleVehicles)v).foldRoof();
              v.drive();

              // Or.. only some of them are ( safer ) .
              if( v instenceOf ConvertibleVehicle ) { 
                  ((ConvertibleVehicles)v).foldRoof();
              } 
              v.drive();
            }
       }
  }