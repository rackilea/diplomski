if( tempQuizList.size() > 0 ){              
    if(clickedRadioAnswer.answerID.equals(bestAnswer.answerID)){
        Quiz.updateAnswer(clickedRadioAnswer.questionID, currentUser.email, 5000);
    } 
    if(!clickedRadioAnswer.answerID.equals(bestAnswer.answerID)){
        Quiz.updateAnswer(clickedRadioAnswer.questionID, currentUser.email, 0);
    }
}

// Quiz is empty or user has no quizquestion open
if(tempQuizList.size() == 0){
    if(clickedRadioAnswer.answerID.equals(bestAnswer.answerID)){
    Quiz.createAnswer(clickedRadioAnswer, currentUser.email, 5000);
} 
else{
    Quiz.createAnswer(clickedRadioAnswer, currentUser.email, 0);
}