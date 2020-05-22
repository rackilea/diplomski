char num [] = { 'f','2','3','a','9','5'};

    System.out.println(num);
    for ( int i = 0; i < num.length - 1; i ++ )  
    {
         for (int j = i + 1; j < num.length; j ++ )
         {
             if(   Character.isDigit(num[i]) 
                && Character.isDigit(num[j])  
                && num[i] < num[j])  {
                 char temp = num[ i ];   //swapping
                 num[ i ] = num[ j ];
                 num[ j ] = temp;
             }
         }           
    }
    System.out.println(num);//Prints f95a32