String pattern1 = "<pre.*?>(.+?)</pre>";
Matcher m = Pattern.compile(pattern1, Pattern.DOTALL).matcher(html);
if(m.find()) {
    String temp = m.group(1);
    System.out.println(temp);
}