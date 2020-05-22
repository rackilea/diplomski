public void runMenu() {

    int x = 1;
    Scanner Option = new Scanner (System.in);
    int Choice = 0; 

  do{  
    try{



           System.out.println("Choose Option");
             System.out.println("");
             System.out.println("1: Create Account");
             System.out.println("2: Check Account");
             System.out.println("3: Take Action");
             System.out.println("4: Exit");



        System.out.println("Please choose");
         Choice= Option.nextInt();  




    switch (Choice)  //used switch statement instead of If else because more effective
    {
    case 1:

        CreateAccount();
        break;   //breaks iteration




    case 2: 

        selectAccount();


        break;

    case 3:


        break;
    case 4:
        System.out.println("Bye"); 
        System.exit(0);
    default:
        System.out.println("Invalid Entry");
        break;


} 
}



catch (Exception e){
    System.out.println("Cant do that"); 
}
} while (true);

}