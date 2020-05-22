for(int i = 0; i < cAnswers.length && i < rAnswers.length; i++)
{
    if(cAnswers[i].equals(rAnswers[i]))
    {
        count++; //Increments count to indicate a match
        System.out.println("The current count: " + count);
    }
}