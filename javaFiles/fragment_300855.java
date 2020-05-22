int factorCount = 0;
for(int i = 1; i <= numFac; i++)
{  
    if(numFac%i == 0)
    {
       factorCount++;
       System.out.print(i+" ");
    }
}
System.out.println("Number of factors " + factorCount;