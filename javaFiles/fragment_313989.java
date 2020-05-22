boolean isValid = true;
int totalamount = 85000;
while(isValid){
  System.out.println("Please select type of Transaction 1.Balance Enquiry 2.Withdraw Money 3.Exit");
        int option = sc.nextInt();
        System.out.println("your choice is..." + option);
         if (option == 2) {
            System.out.println("enter amount to withdraw");
            int amount = sc.nextInt();
            System.out.println("Remaining Balance in your account is..."
                    + (totalamount - amount));
        } else if(option == 3){
           //exit
           isValid = false;
         }
        System.out.println("Do you want to continue? 1.yes 2.no");

        int lastPrompt = sc.nextInt();

        if(lastPrompt == 2){
         break; or isValid = false;
         }
}