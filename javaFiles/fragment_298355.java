String line = "Order QT300. Now!";
String[] pattern = new String[3];
pattern[0] = ".*Q[^u]\\d+\\..*";
pattern[1] = ".*?";
pattern[2] = "ABC";

for (String pat : pattern) {
    if (line.matches(pat)) {
        System.out.println(line + " matches \"" + pat + "\"");
    } else {
        System.out.println("NO MATCH");
    }
}