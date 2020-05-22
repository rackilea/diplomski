while(i>0)
    {
        if(p1.iPower[i]==1)// here is my exception!
        {
            p2.iPower[i]=1;//I know it does not derive my polinom 
            p2.iCoefficient[i]=p1.iCoefficient[i];
            count++;// use this to know the nr of the result polinom terms

        }
        i++;
    }