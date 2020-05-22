while(x < questions.length){
        problem.setText(questions[x]);
        response[y] = String.format("%s",event.getActionCommand());
        input.setText("Answer goes here");
        x++;
        y++;
   }