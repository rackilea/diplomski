for(int i=0; i<correct.length; i++){
    if(answers[i] == correct[i]){
        totalGrade += 1;
    } else if(answers[i]!=0){
        totalGrade -= 0.25;
    }
}