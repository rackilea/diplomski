StringBuffer buf = new StringBuffer();
    Pattern pattern = Pattern.compile("<a href=\"([^\"]*)\">");
    Matcher matcher = pattern.matcher(htmlBody);
    while (matcher.find()) {
        String url = replaceUrl(matcher.group(1));
        matcher.appendReplacement(buf, "<a href=\"" + url + "\">");
        System.out.println(matcher.group(0));
    }
    matcher.appendTail(buf);
    System.out.println(buf.toString());