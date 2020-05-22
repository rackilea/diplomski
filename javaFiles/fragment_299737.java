int totalScore = 0;
    for (int n = 0; n < QArray.length; n++) {
        System.out.println("Question" + (n + 1));
        System.out.println(QArray[n]);

        for (int m = 0; m < 3; m++) {
            String ans = scanner.nextLine();
            Random dice = new Random();
            int t = dice.nextInt(9) + 1;
            int scoremarks = 5;
            if (ans.equalsIgnoreCase(AArray[n])) {
                totalScore += (scoremarks + t);
                System.out.println("That is correct!\nYour score is:" + scoremarks + "\nWith bonus your total score is:" + (scoremarks + t));
                // correct = false;
                break;
            } else {
                System.out.println("That is incorrect!\nYou got 0 Marks\nYour score is 0!");
            }
        }
    }