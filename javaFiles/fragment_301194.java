int length1 = inputStr1.length();
int length2 = inputStr2.length();

int shorterS;
if(length1 <= length2)
   {shorterS = length1;}
 else
   {shorterS = length2;} 


int numDiff = 0;

for(int j=0; j<shorterS; j++)
{
  if(inputStr1.charAt(j) != inputStr2.charAt(j))
   System.out.print((j-1)+" "+inputStr1.charAt(j)+" "+inputStr2.charAt(j)); numDiff=numDiff++;