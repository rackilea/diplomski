unit : ID 
     { 
         try {
             UnitMeasures.valueOf($unit.text);
         }
         catch(IllegalArgumentException e) {
             //report invalid unit
         }
     }
     ;