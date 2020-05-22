String regex = "%([^%.]+)%|(?<!\\$)\\$(?:\\{([^\\{}]+)\\}|([^$.\\s]+))";
String string = "%ABC%\n$ABC.\n$ABC$XYZ  ${ABC}\n\n$$EFG $${EFG}.";
Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
Matcher m = pattern.matcher(string);
List<String> results = new ArrayList<>();
while (m.find()) {
    results.add(Objects.toString(m.group(1),"") + 
        Objects.toString(m.group(2),"") + 
        Objects.toString(m.group(3),""));
}
System.out.println(results); // => [ABC, ABC, ABC, XYZ, ABC]