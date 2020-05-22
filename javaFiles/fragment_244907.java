StringBuilder sentence = new StringBuilder();

//add spaces between the words
for(int i=0; i < input.length(); i++)
{
  char letter = input.charAt(i);
  if(i != 0 && Character.isUpperCase(letter))
  {
    sentence.append(' ');
    sentence.append(Character.toLowerCase(letter));
  }
  else
  {
    sentence.append(letter);
  }
}