double averageScore = 0;
if (scoreCount != 0) 
    avergageScore = scoreTotal / scoreCount;

// or, if you like the ternary operator better:

double averageScore = 
    (scoreCount == 0) 
       ? 0 
       : (scoreTotal / scoreCount);