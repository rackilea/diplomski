Pattern pattern = Pattern.compile("(.*<parent>.*?<tagToFind>)(.*?)(</tagToFind>.*)", Pattern.DOTALL);

String testString = "<root>\n" +
            "  <parent>\n" +
            "    <t1>...</t1>\n" +
            "    <t2>...</t2>\n" +
            "    <tagToFind>something in the tagToFind</tagToFind>\n" +
            "    <tN>...</tN>\n" +
            "  </parent>\n" +
            "  <tagToFind>...</tagToFind>\n" +
            "</root>";

Matcher m = pattern.matcher(testString);
if(m.matches()){
    System.out.println("Found string");
    System.out.println("Value: " + m.group(2));
}