String generateRegex(List<String> words)
{
   if(words.isEmpty()) return "";
   String word = words.remove(0);
   return "\\b(?:" + word + generateInnerRegex(words) + ")";
}

String generateInnerRegex(List<String> words)
{
   if(words.isEmpty()) return "";
   String word = words.remove(0);
   return "(?:(\\s+)" + word + generateInnerRegex(words) + ")?";
}