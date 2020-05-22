public void inputToNumbers()
    {
        for(int i=0; i<length; i++) // Declares i as 0, while i less than length loop runs. Increments each time
        {
            System.out.println("Input five whole numbers, separated by new lines:" + " (" + (i+1) + "/5)");
            String inputtedNums; // Declares inputtedNums string
            inputtedNums = sc.nextLine(); // Inserts input
            while (inputtedNums.matches("^-?[^\\d]+$")) // Checks if the input is not number 
            {
                System.out.println("Error! You inputted an invalid number, try again." + " (" + (i+1) + "/5)");
                inputtedNums = sc.nextLine();

            }
            numbers[i] = Integer.parseInt(inputtedNums);
            // Parses string input into integer numbers
        }
    }