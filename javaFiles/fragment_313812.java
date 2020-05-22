StringBuilder sb = new StringBuilder();
sb.append("<table border=\"2\">");
sb.append("<tr>");
sb.append("<th>Sr. No.</th>");
sb.append("<th>Text Data</th>");
sb.append("<th>Number Data</th>");
sb.append("</tr>");
for (int i = 0; i < 10; ) {
    i++;
    sb.append("<tr>");
    sb.append("<td>");
    sb.append(i);
    sb.append("</td>");
    sb.append("<td>This is text data ");
    sb.append(i);
    sb.append("</td>");
    sb.append("<td>");
    sb.append(i);
    sb.append("</td>");
    sb.append("</tr>");
}
sb.append("</table>");