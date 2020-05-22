}catch(InputMismatchException e){

    System.out.println("Error , only numbers!!");
    sc.nextLine();
    // Put 2 second delay
    try{
         Thread.sleep(2000);
    }catch(InterruptedException ex){
       ex.printStackTrace();
    }
    menu();

}