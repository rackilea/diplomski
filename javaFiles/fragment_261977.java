int terminate = 0;

do {
        Random randomNumbers = new Random();

        card = randomNumbers.nextInt(13) + 1;  
        System.out.println("Card is " + card);  

        System.out.print("Higher or Lower?");
        userResponse = scan.next();
        cardNext = randomNumbers.nextInt(13) + 1;

        if ((String.valueOf(userResponse.charAt(0)).equalsIgnoreCase("H") && cardNext > card) ||
         (String.valueOf(userResponse.charAt(0)).equalsIgnoreCase("L") && cardNext < card)) {
           System.out.println("Correct!");
        } else {
           System.out.println("You lost");
           terminate = 1;
        }
} while (terminate != 1);