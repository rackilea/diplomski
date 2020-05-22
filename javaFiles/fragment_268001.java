class Sample {
     private Integer Variable1 = 0;
     function void something() {
         // Local variable gets the same name as the member "Variable1"
         Integer Variable1 = 1;
         // now we need to use "this.Variable1" to access the "outer"
         // scopes "Variable1" because the name "Variable1" is bound to
         // the local variable "Variable1"
         if(Variable1.equals(this.Variable1)) {
            // Local - meaning in the method body - Scope overrides are not allowed so this gives an error 
            Integer Variable1 = 2;
         }
     }
}