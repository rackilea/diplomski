switch(v.getId()){
        case R.id.bAnswer1:
            if (this.question.isCorrect(button.getText().toString(),this.correctAnswer)){
                button.setBackgroundColor(0xFF4CAF50);//Set button background color to green
            }else{
                button.setBackgroundColor(0xFFF44336);//Set button background color to red
            }
             getNewQuestion();
             break;
        case R.id.bAnswer2:
            if (this.question.isCorrect(button.getText().toString(),this.correctAnswer)){
                button.setBackgroundColor(0xFF4CAF50);//Set button background color to green
            }else{
                button.setBackgroundColor(0xFFF44336);//Set button background color to red
            }
            getNewQuestion();
            break;
        case R.id.bAnswer3:
            if (this.question.isCorrect(button.getText().toString(),this.correctAnswer)){
                button.setBackgroundColor(0xFF4CAF50);//Set button background color to green
            }else{
                button.setBackgroundColor(0xFFF44336);//Set button background color to red
            }
            getNewQuestion();
            break;
        case R.id.bAnswer4:
            if (this.question.isCorrect(button.getText().toString(),this.correctAnswer)){
                button.setBackgroundColor(0xFF4CAF50);//Set button background color to green
            }else{
                button.setBackgroundColor(0xFFF44336);//Set button background color to red
            }
            getNewQuestion();
            break;
   }