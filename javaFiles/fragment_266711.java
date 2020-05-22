String str = "this cat is small. dog is pet anmial. this mouse is small.this toy is small.";
Pattern ptr = Pattern.compile("this\\s(?!cat).*?small");
Matcher matcher=ptr.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group());
}