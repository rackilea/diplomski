Pattern p = Pattern.compile("(\\d+\\.\\d+)\\s+(.*?)\\n(.*$)");
    Matcher m = p.matcher(text);
    if(m.find()) {
        obj.put("Chapter", m.group(1));
        obj.put("Title", m.group(2));
        obj.put("Text", m.group(3));
        System.out.println(obj);
    }