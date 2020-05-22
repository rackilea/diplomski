for (int i = 0; i < 26; i++) {
        char letter = (char) (i + 65);
        Button button = new Button(String.valueOf(letter));
        button.setOnAction(event -> letterGuess(letter));
        alphabet.add(button);
    }