String sentance = "Bang Dang the dang and DANG and I don't mind a dANg and some more";
String[] split = sentance.split("(?i)dang");
StringBuilder sb = new StringBuilder(sentance.length());
for (int index = 0; index < split.length - 1; index++) {
    String part = split[index];
    System.out.println("[" + part + "] " + part.trim().isEmpty());
    if (!part.trim().isEmpty()) {
        sb.append(part).append("#!");
    } else {
        sb.append("#!");
    }
}
// Put the last value at the end, so we don't end up with #! at the end of the String
sb.append(split[split.length - 1]);

System.out.println(sb.toString());