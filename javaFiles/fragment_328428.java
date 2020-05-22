s=s+" ";
    l=s.length();
    for(i=0;i<l;i++)
    {
        ch=s.charAt(i);
        if(ch!=' ')
        w=w+ch;
        else
        {
            word=w;
            w="";
            for(j=0;j<word.length()-1;j++)
            {
                c=word.charAt(j);
                d=word.charAt(j+1);
                if(d==c+1)
                System.out.print(word+"  ");
            }
        }
    }