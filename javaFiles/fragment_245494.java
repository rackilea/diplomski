if(isValidPosition(east))
{
    if(east.getLetter() == 'e')
    {
        east.setPosition(curr);
        theStack.push(east.getPosition());
        foundGoal = true;
    }
    else if((!foundGoal)&&(east.getLetter() == '0')&& (east.getLetter() != '.'))
    {
        east.setLetter('.');
        theStack.push(east.getPosition());
    }
}