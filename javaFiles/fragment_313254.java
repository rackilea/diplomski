do{
int n = rand.nextInt(50);
int m = rand.nextInt(50);
int o = rand.nextInt(50); 

System.out.println("blah blah fortune");
System.out.println("input your name"); // This part doesn't work the second time
String name = scanner.next();

System.out.println();
Prediction(name,n,m,o);
System.out.println();

 System.out.println("do you wish to guess another fortune?");
    System.out.println("1 is yes other number no");
    //this part I will omit tests if the answer is valid and if it should repeat 
   itself, it works for now.


 }
 while (repeat==true);