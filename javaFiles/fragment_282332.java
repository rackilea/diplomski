public static String escape(final String string, boolean brOnly) {
    String out = string;
    if (!brOnly) {
        out = StringEscapeUtils.escapeHtml(out);
    }
    out = StringUtils.replace(out, "\n", "<br />");
    out = StringUtils.replace(out, "\\n", "<br />");
    return out;
}