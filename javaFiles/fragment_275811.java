String displayString = "abc @{fieldOne} defg @{FieldTwo} 123 @{FieldThree} zyx";

Pattern pattern = Pattern.compile("@\\{[a-zA-Z]*\\}");
Matcher matcher = pattern.matcher(displayString);
while ( matcher.find() ){
    System.out.println(matcher.group(0));
}