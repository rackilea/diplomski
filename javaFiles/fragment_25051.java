public static void main( String args[] ) //Standard header for main method
 {
            //User inputs
UserEntry input = new UserEntry(); //Creating object from UserEntry class


Double totalImpulse = null;
while(totalimpulse==null){

    System.out.print("\nPlease enter Total impulse delivered: ");
    try { 
     totalimpulse=  input.getDoubleFromConsole();
 }
 catch(Exception e){
System.out.println("please enter a number:");
}
}
Double averageImpulse=null;
while(averageImpulse==null){
    System.out.print("Please enter Average impulse delivered: ");

    try{
        averageImpulse= input.getDoubleFromConsole();
    }
    catch(Exception e){
System.out.println("please enter a number:");
}
}
}