int i = 0;

for(char c : str1.toCharArray())
{
   if(c != str2.charAt(i++))
      counter++;
}

if(counter > 1)
  // mismatch