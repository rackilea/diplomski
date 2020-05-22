for(int index = 0; index < 13; index++)
{
    int nextVal = inFile.nextInt();
    if(nextVal  < 0)
    {
       pos[index] = nextVal ; 
    }
    else
    {
        neg[index] = nextVal ;
    }
}