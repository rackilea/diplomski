if(!answerContent.endsWith("?"))
        {
            //we have an answer
            int enteredAnswer = Integer.parseInt(answerContent.substring(2));
            int exScore = getScore();

            if(enteredAnswer==answer) // error: enteredAnswer cannot be resolved to a variable
            {
            //correct
            scoreTxt.setText("Score: "+(exScore+1)); //error: exScore cannot be resolved to a variable
            response.setImageResource(R.drawable.tick);
            response.setVisibility(View.VISIBLE);
            }
        } else
        {
            //incorrect
            scoreTxt.setText("Score: 0");
            response.setImageResource(R.drawable.cross);
            response.setVisibility(View.VISIBLE);
            setHighScore();
        }