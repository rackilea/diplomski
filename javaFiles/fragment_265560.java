String str = "WIFLYMODULE-3253 WIFLYMODULE-1585 WIFLYMODULE-1632";
Pattern p = Pattern.compile("\\bWIFLYMODULE-[0-9]{4}\\b");
Matcher m = p.matcher(str);
while (m.find()) {
    System.out.println(m.group());
}