String changeString(String s)
{
   char[] characters = s.toCharArray();
   int rand = (int)(Math.random() * s.length());
   characters[rand] = '_';
   return new String(characters);
}