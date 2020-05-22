boolean hasWhite = false;
for(int i=0; i < string.length(); i++)
{
  if(Character.isWhitespace(string.charAt(i)))
  {
     hasWhite = true;
     break;
  }
}

return hasWhite;