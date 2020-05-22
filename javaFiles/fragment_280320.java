boolean isValid = false;
    Scanner myScanner = new Scanner(System.in).useDelimiter("\\n");
    String customerType = null;
    System.out.print("Customer Type? (C/R) ");
    customerType = myScanner.next();
    while (!isValid)
    {
        System.out.print("Enter Subtotal: ");

        if (myScanner.hasNextDouble())
        {
            double sobTotal = myScanner.nextDouble();
            isValid = true;
        }
        else
        {
            System.out.println("Hay! Entry error please enter a valid number");

            if(myScanner.hasNext()){
              myScanner.next();
            }
        }
    }