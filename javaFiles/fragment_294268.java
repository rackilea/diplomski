public static String getConcatenated(char delim, Object... objs) {
    if(objs == null || objs.length == 0)
        return "";

    StringBuilder sb = new StringBuilder();
    for (Object o : objs) {
        if(o != null) {
            if (sb.length() > 0) sb.append(delim);
            sb.append(o.toString().trim());
        }
    }
    return sb.toString();
}