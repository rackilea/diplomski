int lowScore = 0;
int count = 0;
boolean isLowScoreValid = false; // the variable

if(!isLowScoreValid || count < lowScore){ // update if any value were't set
    lowScore = count;
    isLowScoreValid = true; // now a value is set
}

System.out.println("\n        Best Score: " +(isLowScoreValid ? lowScore : "(none)"));