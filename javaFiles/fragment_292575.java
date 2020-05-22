//get length of our string
    int userAnswerLength = getUserAnswerString.length();

    //get all the characters except for the last one ans assign to your variable
    //getUserAnswerString will be "NEVERMIN" after the below line executes
    getUserAnswerString = getUserAnswerString.substring(0, userAnswerLength - 1);