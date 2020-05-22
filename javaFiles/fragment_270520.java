int max1,max2;
if(times[0]>times[1])
{
    max1=times[0];
    max2=times[1];
}
else
{
    max1=times[1];
    max2=times[0];
}
for(int i=2;i<times.length;i++)
    if(times[x]>max1)
    {
        max2=max1;
        max1=times[x];
    }
    else if(times[x]>max2)
        max2=times[x];