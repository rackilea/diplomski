private static boolean findSequenceRecHelper(char [] findIn, char c, int index)
{
boolean result = false;
if(index<findIn.length)
{
    if(findIn[index] == c)
        result = true;
    else
    return findSequenceRecHelper(findIn,c,index+1);
    //^ 
    //added return here
}
return result;
}