List<String> parts = new ArrayList<>();
String keyword = "apple mango \"jack fruit\" \"ice cream\"";

// first use a matcher to grab the quoted terms
Pattern p = Pattern.compile("\"(.*?)\"");      
Matcher m = p.matcher(keyword);
while (m.find()) {
    parts.add(m.group(1));
}

// then remove all quoted terms (quotes included)
keyword = keyword.replaceAll("\".*?\"", "")
                 .trim();

// finally split the remaining keywords on whitespace
if (keyword.replaceAll("\\s", "").length() > 0) {
    Collections.addAll(parts, keyword.split("\\s+"));
}

for (String part : parts) {
    System.out.println(part);
}