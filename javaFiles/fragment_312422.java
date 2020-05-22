OnClickListener buttonClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {

            if((guessText.getText().toString()).length() == 0)
            {
                Toast.makeText(getApplicationContext(), "no number entered", Toast.LENGTH_SHORT).show();
            }
            else{
                int userNumber = Integer.parseInt(userGuess.getText().toString());

                                     if ( userNumber < 1 || userNumber > 10 ) {
            guessText.setText("Please guess 1 - 10");
        } else if ( userNumber == rando) {
            guessText.setText("You Got It Right!");
            if (applause.isPlaying()) {
                applause.seekTo(0);
            } else {
              applause.start();
            }
        } else {
            guessText.setText("Not quite, guess again!");
        }

        randText = Integer.toString(rando);
        textOne.setText(randText);

        userGuess.setText("");
            }
        }
    };

    pushMe.setOnClickListener(buttonClickListener);