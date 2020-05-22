int[] array = {17,11,1,13};
string polynomialString = "";
for(int i = array.length - 1; i >= 0; i--)
{
  if(i > 1)
  {
    polynomialString += array[i] + "*n^" + i + "+";
  }
  else if(i == 1)
  {
    polynomialString += array[i] + "*n+";
  }
  else
  {
    polynomialString += array[i];
  }
}
return polynomialString;