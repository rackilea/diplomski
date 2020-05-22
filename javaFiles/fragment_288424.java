// within your while loop
int temp=data[data.length-1];
for(int i=data.length-1;i>=1;i--)
{
  data[i] = data[i-1];
}
// decrease the position now
 data[0]=temp;