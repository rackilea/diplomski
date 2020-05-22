public String parseLinks(String raw) {
    String openTag = "<a href=\"";
    String closeTag = "</a>";
    String result = "";

    int start = 0;
    int middle = raw.indexOf(openTag);
    int end;
    while(middle > -1) {
        result += raw.substring(start, middle);

        end = raw.indexOf("\">", middle);
        result += raw.substring(middle + openTag.length(), end);

        start = raw.indexOf(closeTag, end) + closeTag.length(); 
        middle = raw.indexOf(openTag, start);
    }

    result += raw.substring(start, raw.length());
    return result;
}