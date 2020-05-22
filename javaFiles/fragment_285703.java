String s = "many??? Woooooooooooords are"; 
Pattern pattern = Pattern.compile("(?s)^(?=.*([a-z])$)|[a-zA-Z]+");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    if (matcher.group(1) != null) {
        System.out.println("Last letter: " + matcher.group(1));
    }
    else {
        System.out.println("Word found: " + matcher.group(0)); 
    }
}