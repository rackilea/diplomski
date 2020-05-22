if(phrase.length() < i+2 
   && phrase.charAt(i) == '|') 
   && phrase.charAt(i+1) == '_' 
   && phrase.charAt(i+2) == '|')
{
    NewString += "u";
    i += 2;  // Will get the third increment from loop
    continue;
}