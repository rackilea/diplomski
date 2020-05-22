bool status=true;

for (int i = 0; i < input.size(); i++) {

   if(input[i] == 0)
   {
       status=false;
       break;
   }
}

if(status)
{  // do  your stuff}