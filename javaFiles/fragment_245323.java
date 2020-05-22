public void menu()
 {
        System.out.println("Welcome to your Payroll System");
        System.out.println();
        System.out.println("Please enter your choice below from the following options");
        System.out.println();
        System.out.println("View all current weekly employees = 1 ");
        System.out.println("View all current monthly employees = 2 ");
        System.out.println("Delete an employee = 3 ");
        System.out.println("Add an employee = 4 ");
        System.out.println("Print an employee payslip = 5");
        System.out.println("To exit the system = 0 ");

        // allows user to enter number of choice and this reflects which statement is ran in userChoice method
        try {
             tempvar = sc.nextInt();
        } catch (InputMismatchException e) {
             System.out.println("...");
        }
        userChoice();
 }