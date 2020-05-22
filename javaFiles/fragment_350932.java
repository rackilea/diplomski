for(int i=0;i<appword.length;i++)
{
    if((i < guessword.length) && (guessword[i]==appword[i]))
    {
        c=true;
    }
    else
    {
        c=false;
        break; // <<<=== Add this to end the loop
    }
}