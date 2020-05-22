// SCOPE0 - contains "Sample" and all classes/interfaces... available
class Sample {
     // SCOPE1 - contains all from SCOPE0 and "Variable1" and "something"
     private Integer Variable1 = 0;
     function void something() {
         // now here it gets special, a variable is only visible after
         // declaration so java basically has a new local scope for each declaration
         // SCOPE2 - contains all from SCOPE1 and some specials like `this`
         Integer Variable2 = 1;
         // SCOPE3 - contains all from SCOPE1 and "Variable2"
         if(Variable1.equals(Variable2)) {
            // SCOPE4 - contains all from SCOPE3 
            Integer Variable3 = 2;
            // SCOPE5 - contains all from SCOPE4 and "Variable3" 

            // END OF SCOPE5 and SCOPE4
         }
         // now this will give an error because "Variable3" is not visible anymore
         Variable2 = Variable3;
         // END OF SCOPE3 and SCOPE2
     }
}