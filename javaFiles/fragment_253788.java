String[] input = {
        "account[id].attr",
        "account[anotherid].anotherattr"
};
//                           | literal for "account"
//                           |      | escaped "["
//                           |      |  | group 1: any character 
//                           |      |  |   | escaped "]"
//                           |      |  |   |  | escaped "."
//                           |      |  |   |  |  | group 2: any character
Pattern p = Pattern.compile("account\\[(.+)\\]\\.(.+)");
Map<String, String> output = new LinkedHashMap<String, String>();
// iterating over input Strings
for (String s: input) {
    // matching
    Matcher m = p.matcher(s);
    // finding only once per input String. Change to a while-loop if multiple instances
    // within single input
    if (m.find()) {
        // back-referencing group 1 and 2 as key -> value
        output.put(m.group(1), m.group(2));
    }
}
System.out.println(output);