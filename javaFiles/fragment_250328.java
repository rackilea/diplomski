int total = 0;

for(int i=0; i < str.length(); i++)
{

   if(!Character.isWhitespace(str.charAt(i)))
     total++;
}

System.out.println("total non-whitespace characters are " + total);