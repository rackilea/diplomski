String s = ""
    + "===Albedo–temperature feedback===\n"
    + "When an area's albedo changes due to snowfall, a snow–temperature [[feedback]] results. \n"
    + "\n"
    + "===Snow===\n"
    + "Snow albedo is highly variable, ranging from as high as 0.9 for freshly fallen snow, to about 0.4 for melting snow, and as low as 0.2 for dirty snow.\n"
    + "\n"
    + "====Small-scale effects====\n"
    + "Albedo works on a smaller scale, too.\n";
Pattern PAT = Pattern.compile("^()$|^={2,5}(.+?)={2,5}$|^(.+)$", Pattern.MULTILINE);
String NEWLINE = "\n";
Matcher m = PAT.matcher(s);
int number = 0;
StringBuilder sb = new StringBuilder();
while (m.find()) {
    if (m.group(2) != null)
        sb.append(++number).append(". ").append(m.group(2));
    else if (m.group(3) != null)
        sb.append("content: ").append(m.group(3));
    sb.append(NEWLINE);
}
System.out.println(sb.toString());