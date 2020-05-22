double temp_usr= 0.0; //declaring here switch will make it visible in the following code
switch( switch1){
case 1: 
{
System.out.println(" You have selected Celsius");
Scanner temp_ip= new Scanner(System.in);
System.out.println("Please enter the temperature in celsius");
temp_usr= temp_ip.nextDouble();
}   
break;
case 2: ...............
case 3: ...............

switch(switch2) {
case 1: 
{
System.out.println("convert it into Celsius");
System.out.println(cels(arg));  /*this argument should take value of temp_usr*/
}
break;
case 2: .........  
case 3: .........