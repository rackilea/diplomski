while (!text.equals("yes")) {
        System.out.println("Is your number " + (guess) + "?");
        System.out.println("yes,higher,or lower");
        text = reader.nextLine();

        if (text.equals("higher")) {
            min = guess;
        }
        if (text.equals("lower")) {
            max = guess;
        }
        guess = (max + min) / 2;
    }