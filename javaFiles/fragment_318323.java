for (int inner = 0; inner < NUMBER_OF_ENDS; inner++) {
        for (int counter = 0; counter < player.length; counter++) {

            System.out.print("Enter score number " + (inner + 1) + " score for " + player[counter]+"---->");
            scores[counter][inner] = input.nextInt();

        }
    }