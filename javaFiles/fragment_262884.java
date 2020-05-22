for (String s : returns) {
    String[] s2=s.split("-");

    out.append("<tr>");
    for(String results : s2)
    {
        out.append("<td>");
        out.append(results);
        out.append("&nbsp;");
        out.append("</td>");
    }
    out.append("</tr>");
}