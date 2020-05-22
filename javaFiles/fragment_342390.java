String pattern1 = "<pre.*?>([\\s\\S]+?)</pre>";
Matcher m = Pattern.compile(pattern1).matcher(html);
if(m.find()) {
    String temp = m.group(1);
    System.out.println(temp);
}