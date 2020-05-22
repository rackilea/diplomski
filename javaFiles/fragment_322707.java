String input = "*********** name: NOTINSTATE timestamp: 2015-09-16T12:33:01.253Z\n" +
               "MyKeyValue1 = myData MyKeyValue2 = 0.0 based on filter: no Filter\n" +
               "********************************";
String regex = "\\*+\\s+" +
               "(name):\\s+(.*?)\\s+" +
               "(timestamp):\\s+(.*?)\\s*[\r\n]+" +
               "(MyKeyValue1)\\s+=\\s+([^=]*)\\s+" +
               "(MyKeyValue2)\\s+=\\s+([^=]*)\\s+" +
               "(based on filter):\\s+(.*?)\\s*[\r\n]+" +
               "\\*+";
Matcher m = Pattern.compile(regex).matcher(input);
if (m.matches()) {
    Map<String, String> pairs = new LinkedHashMap<>();
    for (int i = 1; i <= 10; i += 2)
        pairs.put(m.group(i), m.group(i + 1));

    // print for testing
    for (Entry<String, String> entry : pairs.entrySet())
        System.out.printf("\"%s\" %s%n", entry.getKey(), entry.getValue());
}