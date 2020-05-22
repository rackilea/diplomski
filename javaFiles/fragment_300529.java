long currentValueFN = 0;
long value = 0;
char[] currentFN = new char[text.length()];
currentFN = text.toCharArray();
Long l = Long.parseLong(String.valueOf(currentAge));  
while(currentValueFN < l ) //check if current value is enough
{

  for(int i=0; i<text.length(); i++) 
  {
     currentValueFN += valueLetters( currentFN[i] );                     
     if(currentValueFN >= l)
     {
        value = valueLetters( currentFN[i] );
        break;
     }
  }
} 
return value;