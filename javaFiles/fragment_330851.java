public static String escapeHtml(String s) {
        String escaped = "";
        if(null != s) {
            escaped = StringEscapeUtils.escapeHtml(s);
            escaped = escaped.replaceAll(" ","&nbsp;"); // HERE
            escaped = escaped.replaceAll("'","&#39;");
            escaped = escaped.replaceAll("\\\\","&#92;");
            escaped = escaped.replaceAll("/","&#47;");
        }
        return escaped;
    }