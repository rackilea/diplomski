private static void field(StringBuilder builder, String tag, Object content) {
    if(content == null) {
        return;
    } else if(content instanceof Iterable) {
        for(Object object: (Iterable) content) {
            field(builder, tag, object);
    }
    return;
} else if(content.getClass().isArray() && !(content instanceof  Map)) {
    for(int i = 0; i < Array.getLength(content); i++) {
        field(builder, tag, Array.get(content, i));
    }
    return;
}
if(content instanceof Double || content instanceof Float) content = String.format("%.2f", content);
if(content instanceof Date) content = dateFormat.format(content);
if(content instanceof Calendar) content = dateFormat.format(new Date(((Calendar) content).  getTimeInMillis()));
builder.append("<");
builder.append(tag);
builder.append(">");
if(content instanceof Map) {
    Map map = (Map) content;
    for(Object object: map.entrySet()) {
        Map.Entry entry = (Map.Entry) object;
        field(builder, (String) entry.getKey(), entry.getValue());
    }
} else {
    try { //making sure that characters are decoded in case they
        //are encoded
        content = URLDecoder.decode(content.toString(), "UTF-8");
    } catch (UnsupportedEncodingException e) {
        //silently ignores error
        //and content will be untouched
    }
    String value = content.toString().
            replace("&", "&amp;").
            replace("<", "&lt;").
            replace(">", "&gt;").
            replace("'", "&apos;").
            replace("\"", "&quot;");
    builder.append(value);
}
builder.append("</");
builder.append(tag);
builder.append(">");}