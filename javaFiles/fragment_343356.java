if (userInput.equals(allNumbersWinner)) {
         System.out.println("Winner: " + allNumbersWinner );
         System.out.println("Congratulations, both pairs matched.");
    }else if(userInput.substring(0,2).equals(firstTwoWinner )) {
        System.out.println("Winner: " + allNumbersWinner);
        System.out.println("Congratulations, the front pair matched.");
    }else if (userInput.substring(1,3).equals(lastTwoWinner)) {
         System.out.println("Winner: " + allNumbersWinner );
         System.out.println("Congratulations, the end pair matched.");
    }else {
         System.out.println("Winner: " + allNumbersWinner );
         System.out.println("Sorry, no matches. You only had one chance out of 100 to win anyway.");
    }