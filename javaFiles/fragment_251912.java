public void Translator(String s, String l, String[] index)
{
  for (String word : index) {
    String s1=s, l1=l;
    if (word.length()> 0) {
      s1 = l1 + word.substring(1) + word.substring(0, 1).toLowerCase() + "ay";
      l1 = s1;
    }
    System.out.println(s1);
  }
}