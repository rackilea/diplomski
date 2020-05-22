char[] charArray = binary.toCharArray(); 
double answer = 0; 
for (double index = charArray.length - 1; index >= 0; index--)
{
     if (charArray[(int)index] == '1') 
     {
          answer = answer + Math.pow(2.0, index);
     }
}