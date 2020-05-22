public static Integer highestProduct(int array[]) 
{
    if((array==null)||(array.length<3))
    {
        return null;
    }

    else
    {
        int max_product = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++)
        {
            for(int j=i+1;j<array.length;j++)
            {
                for(int k=j+1;k<array.length;k++)
                {
                    int product = array[i]*array[j]*array[k];
                    if(product>=max_product)
                    {
                        max_product = product;
                    }
                }
            }
        }
        return max_product;
     }
 }