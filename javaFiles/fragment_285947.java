Pattern pattern = Pattern.compile("\\([,\\d]+\\)");
Matcher matcher = pattern.matcher(inputString);

while (matcher.find()) {
    String matched = matcher.group();
    //Do something with it  
}