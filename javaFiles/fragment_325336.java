double discount = 0.0;//some default value

   switch (membership)
   {
       case 3: 
           discount = .15;              
           break; 
       case 2: 
           discount = .05
           break;
       //etc.
       default:
           discount = 0.0;//some default value
           break;
   }
   //now do the calculation using the discount variable
   double finalProductCharge = productCharge * (1.0 - discount);