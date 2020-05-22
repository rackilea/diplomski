Pattern pattern = Pattern.compile("\\d+(\\s\\d+)?\\s*[-+*/$£]");

String input = "3 3 * 4 + 2 /";
Matcher matcher = pattern.matcher(input);
ArrayList<String> output = new ArrayList<String>();
while (matcher.find()) {
    output.add(matcher.group());
}


for(String s : output){
    System.out.println(s);
}