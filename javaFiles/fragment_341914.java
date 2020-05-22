String s = "Brooklyn NY 1194-5954";
Pattern pattern = Pattern.compile("^[A-Za-z]+(?:[\\s'-]+[A-Za-z]+)*(?=\\s+[A-Z]{2}\\b)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(0)); 
}