for(int index = 0; index < 13; index++)
{
    if(inFile.nextInt() < 0)
    {
       pos[index] = inFile.nextInt(); 
    }
    else
    {
        neg[index] = inFile.nextInt();
    }
}