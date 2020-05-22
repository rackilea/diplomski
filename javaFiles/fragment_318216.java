boolean rhyme(String words) {
   Pattern pattern = Pattern.compile(".*(.{3})(?=[\\t]).*(.{3}$)");
   Matcher matcher = pattern.matcher(words);

   return matcher.matches() && matcher.group(1).equals(matcher.group(2));
}