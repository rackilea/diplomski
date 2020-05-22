String answer = answerEntered[x];
boolean isAnswerCorrect = 
        answer != null && 
            //remove trailling spaces and ignore case (a==A)
        answer.trim().equalsIgnoreCase(answers[x]);
if(isAnswerCorrect){