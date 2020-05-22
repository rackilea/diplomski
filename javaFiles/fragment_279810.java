System.out.println("Choose a letter: ");
        letter = game.in.next();

        if(letter.length() == 1)
        {
            game.guesses[game.guessed] = letter.charAt(0);
            game.guessed++;
            game.sort();

            if(game.puzzleWord.indexOf(letter.charAt(0)) != -1){
                game.correct = game.correct + letter.charAt(0);
                game.puzzle = game.puzzleWord.replaceAll("[^"+game.correct+" ]","-");
                if(game.puzzleWord.replaceAll("["+game.correct+" ]","").length() == 0){
                    game.win = true;
                    game.over = true;
                }

            }
            else
                game.PrintWrongGuesses();
        }else
        {
            System.out.println("Invalid input, try again");
        }