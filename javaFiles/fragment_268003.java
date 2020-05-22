try{
     selection = input.nextInt();        
     switch(selection){
      case 1:
          viewAccountInfo3();
          break;
      case 2:
          withdraw3();
          break;
      case 3:
          addFunds3();
          break;
      case 4:
          AccountMain.selectAccount();
          break;
      case 5:
          System.out.println("Thank you for using this ATM!!! goodbye");
          break;
      default:             
          System.out.println("Invalid choice.");
          businessAccount();

      }
}catch(InputMismatchException e){
    //do whatever you wanted to do in case input is not an int
}