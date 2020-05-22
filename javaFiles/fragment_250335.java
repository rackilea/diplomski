Pattern p = Pattern.compile("tresc=\"(.*?)\";");
Matcher m = p.matcher(str);

if (m.find()) {
    System.out.println(m.group(1));
}