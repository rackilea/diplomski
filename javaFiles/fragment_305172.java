try{
    Integer.parseInt(max);
    //do something with the integer
}catch (NumberFormatException e)
{
    //user has entered too many digits for an Integer to hold.
    userInput = Integer.MAX_VALUE + "";
}