public static String getValidCustomerType(Scanner sc)
{
    String customerType = ("");

      boolean isValid = false;
      while (isValid == false)
      {
          System.out.println("Enter the Customer Type");
          customerType = sc.nextLine() ;
       if (customerType.equalsIgnoreCase("R")|customerType.equalsIgnoreCase("C") ) 
       {
         isValid = true;
       }
       else
       {
          System.out.println("Error! Invalid customer type. Try again ");
       }   
      }
   return customerType ;
}