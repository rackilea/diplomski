String str = "Niedersachsen,NOT IN CHARGE SINCE: 03.2009, CATEGORY";
Pattern p = Pattern.compile("\\d{2}\\.\\d{4}");
Matcher m = p.matcher(str);

if (m.find()) {
    System.out.println(m.group());
}