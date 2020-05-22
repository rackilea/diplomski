Pattern MY_PATTERN = Pattern.compile("((http(s)?:\\/\\/)?)(www\\.)?((youtube\\.com\\/)|(youtu.be\\/))[\\S]+");
Matcher m = MY_PATTERN.matcher(Content);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, "++++\n" + "<iframe width=\"560\" height=\"315\" src=\"" + m.group(0) + "\" frameborder=\"0\" allow=\"autoplayencrypted-media\" allowfullscreen></iframe>\n++++");
}
m.appendTail(sb);
Content = sb.toString();
Content = Content.replace("youtu.be", "youtube.com/embed");
Content = Content.replace("?t=", "?start=");