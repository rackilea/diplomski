Pattern p = Pattern.compile("\\[{2}((?:.)*?)\\]{2}" );
Matcher m = p.matcher(content.asString());
StringBuffer sb = new StringBuffer();
while (m.find()) {
    String one = m.group(1);
    try {
        m.appendReplacement(sb, "<a href=\"#!p\\:"+URLEncoder.encode(one,"UTF-8")+"\">$1</a>");
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
m.appendTail(sb);