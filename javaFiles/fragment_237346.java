String str = "Niedersachsen,NOT IN CHARGE SINCE: 03.03.2009, CATEGORY";
Pattern p = Pattern.compile("SINCE:(.*?)\\,");
Matcher m = p.matcher(str);

if (m.find()) {
    System.out.println(m.group(1).trim());
}