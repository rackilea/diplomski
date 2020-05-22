List texts<String> = new ArrayList<String>();
Pattern pattern = Pattern.compile("[^0-9\\s]+"); 
String text = "1 apple 2 oranges 3 carrots"; 
Matcher matcher = pattern.matcher(text); 

while (matcher.find()) { 
  texts.add(matcher.group(0)); 
}