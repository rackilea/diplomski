int intervals[11]={0,10,20,30,40,50,60,70,80,90};
for(int i=1; i<11; i++)
{
    if(x>=intervals[i-1] && x<intervals[i])
        tally[i-1]+=1;
}