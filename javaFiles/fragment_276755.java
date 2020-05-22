// This will give it 20 spaces to write the prefix statement and then the
//space left will be "tacked" on as blank chars.
String.format("%-20s",prefixStatement); 

//Below is the printf statement for exactly what you want.
System.out.printf("%-20s$%.2f\n","Gross Amount:",3575.00);
//This executes and returns: **Gross Amount:       $3575.00** 

//Below will get you fifteen spaces every time.
String ga = "Gross Amount:";
System.out.printf("%-"+(ga.length()+15)+"s$%d\n","Gross Amount:",2);
//This executes and returns: **Gross Amount:               $2**