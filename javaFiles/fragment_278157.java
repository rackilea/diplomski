boolean CO = true;
while(true)
{
    for( ; ;) {
        System.out.print("Enter an ID # (0-9): ");
        int IDinput = input.nextInt();

        if( IDinput <10 && IDinput > 0)
            break;

        System.out.println("The ID entered is incorrect. Please enter the correct ID  \n");
    }
    for( ; ; ) {
        System.out.println("\n Main Menu " + "\n 1: check balance " + " \n 2: withdraw" + "\n 3: deposit" + "\n 4: go back to ID" + "\n 5: terminate program");
        System.out.print(" Enter a choice: ");
        int choice = input.nextInt();

        if(choice == 1) {
            System.out.print("\n The balance is " + test.getBalance());
            continue;
        }
        else if(choice == 2) {
            System.out.print("How much would you like to withdraw: ");
            double withdraw = input.nextDouble();
            test.withdraw(withdraw);
            continue;
        }
        else if(choice == 3) {
            System.out.print("How much would you like to deposit: ");
            double deposit = input.nextDouble();
            test.deposit(deposit);
            continue;
        }
        else if( choice == 4)
        {
            break;
        }
        else if(choice == 5)
        {
            CO = false;
            break;
        }
    }

    if(CO == true)
    {
        continue;
    }
    break;
}