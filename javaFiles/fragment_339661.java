for(int i=0; i<4; i++)
{
    try 
    {
        switch(i)
        {
            case 0: a(); break;
            case 1: b(); break;
            case 2: c(); break;
            case 3: d(); break;
        }
    }
    catch(Exception e){} // next
}