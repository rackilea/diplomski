String rx = "\\[\\s+(RUNNING|STOPPED)\\s+\\]\\s+([^\\[]*(?:\\[(?!Pid:)[^\\[]*)*)";
Pattern p = Pattern.compile(rx);
Matcher m = p.matcher("[ RUNNING ] My First Application");
if (m.find()) {
    System.out.println(m.group(1));
    System.out.println(m.group(2));
}