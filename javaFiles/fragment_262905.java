if (SecretWord.indexOf(guess) >= 0) {
        UpWord = dash.substring(0, SecretWord.indexOf(guess));
        UpWord += guess;
        UpWord += dash.substring(SecretWord.indexOf(guess) + 1, dash.length());
        System.out.println(UpWord);
    } else {