public static Employee userInputByName()
    {
         Employee e = null; 
         System.out.println("Please enter the Employee Name:");
         String employeeName = keyboard.nextLine();
         System.out.println("Please enter the Employee Name:"); //!???

         return e =  new Employee(employeeName);
    }