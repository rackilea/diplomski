for() { //this is a for-each loop
 try {
  //my logic
 } catch (Exception e) {
    System.out.println("Exception caught and handled");
        try{
        //Some more logic is written..Like calling a method from another class etc..
        } catch(Exception ex){
            System.out.println("Exception caught inside Catch Block and handled");
        }
 } //end of try-catch block
}end of for-each loop