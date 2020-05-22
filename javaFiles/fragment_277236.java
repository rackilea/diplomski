String line = <yout_html_string>

Pattern p = Pattern.compile("<test>(.*?)</test>");
Matcher m = p.matcher(line);

while (m.find()) {
    // m.group(1) is the text you want
    // store it in a variable
}