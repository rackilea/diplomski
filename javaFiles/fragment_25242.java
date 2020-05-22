if(T[input.length][total])
    {
        int i=input.length-1;
        int j=total;
        while(i!=0||j!=0)
        {
            if(T[i][j])
                i--;
            else
            {
                S1.add(input[i]);
                j-=input[i];
            }
        }
 }