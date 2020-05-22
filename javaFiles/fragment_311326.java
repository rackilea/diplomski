String input = "&#x0D39;&#x0D32;&#x0D47;&#x0D3E; &#x0D38;&#x0D4D;&#x0D31;"
    + "&#x0D4D;&#x0D31;&#x0D3E;&#x0D15;&#x0D4D;&#x0D15;&#x0D4D;&#x0D13;"
    + "&#x0D35;&#x0D7C; &#x0D2B;&#x0D4D;&#x0D32;&#x0D47;&#x0D3E;";
Pattern HEX = Pattern.compile("(?i)&#x([0-9a-f]+);|&#(\\d+);");
Matcher m = HEX.matcher(input);
StringBuffer sb = new StringBuffer();
while (m.find())
    m.appendReplacement(sb,
        String.valueOf((char) (m.group(1) != null ?
            Integer.parseInt(m.group(1), 16) :
            Integer.parseInt(m.group(2)))));
m.appendTail(sb);
String output = sb.toString();
System.out.println(output);
// -> ഹലോ സ്റ്റാക്ക്ഓവർ ഫ്ലോ