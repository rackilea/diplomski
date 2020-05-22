public static String getResponse(String input) {
    if(doesContain(input, negatives)){
        // add return here:
        return getRandResponse(negResponse);
    }
    //If none of the criteria is met, the bot will ask a random question from the questions array.
    return getRandResponse(quesResponse);
}