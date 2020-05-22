String html = "<your html>";
String regex = "(<!--[\\s\\w]+)(<a)(\\s*href=\\\"google\\.com\\\"\\s*>)";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(html);
if (m.find()) {
    System.out.println(m.replaceAll("$1^^$3"));
}