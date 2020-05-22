String input = scanner.nextLine();
        {
            input = input.toLowerCase();

        if (input.equals("front door")  || input.equals("front"))             
                System.out.println("Maggie went to the side of the home and open the basement door.  As the door opened, she could smell the dust from inside.");       
        else if (input.equals("basement") || input.equals("basement entrance"))  
                    System.out.println("Maggie walks up the steps and slowly opens the front door.");               
        else    
            System.out.println("That is not a correct answer");