String s = "abd_12df";
Pattern pattern = Pattern.compile("^\\p{L}+"); // or just Pattern.compile("^[a-zA-Z]+") to get the first one or more ASCII letters
Matcher matcher = pattern.matcher(s);
if (matcher.find()){
    System.out.println(matcher.group(0)); 
}