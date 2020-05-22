...
        System.out.print("Age: ");
        age = sc.nextInt();
        sc.nextLine(); //added

        if(Gender.equals("F") && age >= 20)
        {
            System.out.print("\nAre you married, " + fName + " (Y or N)? ");
            M = sc.nextLine();
            M = M.toUpperCase();

            if(M.equals("Y"))
            {
                type = "Mrs. ";
                type = type.concat(lName);
            }
         ...