String source = "О . Г . дов.";
Pattern p = Pattern.compile("(^[А-Я]\\s*\\.\\s*[А-Я]\\s*\\.)\\s*.*");
Matcher m = p.matcher(source);
if(m.find()) {
    String resultWithoutSpaces = m.group(1).replaceAll(" ", "");
    System.out.println(resultWithoutSpaces);
}