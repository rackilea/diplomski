Pattern pattern = Pattern.compile("your regular expression here");
while((line = readLine()) != null) {
   Matcher m = pattern.matcher(line);
   if (m.matches()) {
      System.out.println(line + " is good");
   } else {
      System.out.println(line + " is not good");
   } 
}