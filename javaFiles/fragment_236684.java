Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(content);
int fileId = -1;
while(m.find()) {
    fileId = -1;
    if (m.group(1) != null) {
        fileId = new Integer(m.group(1));
    }
}