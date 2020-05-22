String userInput = "ABC133456";

    if(!Pattern.matches("[A-Z]{3}[0-9]{6}", userInput))
         System.out.println("Your NetID needs to be 9 characters long, it needs to be in this format: ABC123456");
    else
         System.out.println("Ok!");