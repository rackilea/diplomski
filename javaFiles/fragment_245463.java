GuesstheNum game;

    do {
        String num2 = JOptionPane.showInputDialog(" Guess a integer between 1 and " + max);
        int max2 = Integer.parseInt(num2);
        game = new GuesstheNum(max2);
    } while (game.ChecktheNum());