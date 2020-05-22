bool status=true;

for (int i = 0; i < input.length && status; i++) 
{
   for(j = 0; j < anotherArray.length; j++)
   {
       if(input[i] == anotherArray[j])
       {
           status=false;
           break; // you can use a labeled break if you want
       }
}

if(status)
{  // do  your stuff}