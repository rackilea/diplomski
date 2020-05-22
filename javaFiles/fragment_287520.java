if(ch==' ')
    {
        x=x+' ';
    } else if((int)ch-97<m)
    {
        x=x+(char)((123-m)+(int)ch-97);
    }
    else
    {
        x=x+(char)((int)ch-m);
    }