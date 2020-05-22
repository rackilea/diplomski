if(userAnswer.equalsIgnoreCase(rightAnswer)) {
points++;
    Log.v("checkEditTexts()", "POINTS++: " + points);
}else{
    points--;
    Log.v("checkEditTexts()", "POINTS--: " + points);

}