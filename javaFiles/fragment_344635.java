char[] charArray;
charArray = new char[numberLength];

for(int i = 0; i < (numberLength - 1); i++) // -> Remember, -1 because arrays start at 0!
{
  charArray[i] = my_string.charAt(i);
}