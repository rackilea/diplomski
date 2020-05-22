String selection ="";
        do{
           //output presenting the user with options
            System.out.print("A simple Menu\n");
            System.out.print("Y - Yolk\n");
            System.out.print("N - Naan\n");
            System.out.print("X - Exit\n\n");

            //request user input using the import.util.*; feature
            System.out.print("Enter your selection: ");
            selection=keyboard.nextLine();
            // So here the 'selection' string is made

           }
           //Now here, whatever the user has selected as an option will be 
           // passed through and more options will appear.
           while(!selection.equals("X"));