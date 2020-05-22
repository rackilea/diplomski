primes[counter]=i;
counter=counter+1;
for(int j=i+1;j<=(int)Math.sqrt(m);j++)
{
    if(j%i==0)
    {
        v[j]=false;
    }
}