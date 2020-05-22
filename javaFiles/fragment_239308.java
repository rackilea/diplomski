for (int i = 0; i < 4; i++) {

        if (i == locationOfCorrectAnswers && 
                    !options.contains(answers.get(riddleCounter))) {

                options.add(answers.get(riddleCounter));

        }else {

            incorrectAnswers = random.nextInt(riddles.size());

            while (incorrectAnswers == riddleCounter) {

                incorrectAnswers = random.nextInt(riddles.size());
            }

             if(!options.contains(answers.get(incorrectAnswers)))
                   options.add(answers.get(incorrectAnswers));
             else --i;
        }

    }