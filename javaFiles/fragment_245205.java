//BufferedReader stuff etc.
List<String> words = new ArrayList<String>();
words.add("fun");
words.add("something");

String line;
while( (line = br.readLine()) != null)
{
   boolean found = false;
   for(String word: words)
   {
       if(line.contains(word))
       {
           found = true;
           break;
       }
   }

   if(found) continue;
   System.out.println(line);
}