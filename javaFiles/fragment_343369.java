String msg = "Hello [Start Date + 30] world [ Start Date ].";
StringBuffer sb = new StringBuffer();

Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(msg);

while (m.find()) {

    // What to replace
    String toReplace = m.group(1);

    // New value to insert
    int toInsert = 1000;

    // Parse toReplace (you probably want to do something better :)
    String[] parts = toReplace.split("\\+");
    if (parts.length > 1)
        toInsert += Integer.parseInt(parts[1].trim());

    // Append replaced match.
    m.appendReplacement(sb, "" + toInsert);
}
m.appendTail(sb);

System.out.println(sb);