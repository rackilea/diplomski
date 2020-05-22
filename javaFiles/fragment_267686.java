setLayout(new BorderLayout());
String[][] matrix = new String[][]{
    {"x", "H", "f", "f", "x", "x"},
    {"x", "f", "x", "f", "D", "x"},
    {"x", "H", "f", "f", "x", "x"},};

JLabel label = new JLabel();
StringBuilder sb = new StringBuilder("<html><body>");
sb.append("<table boder=0>");
for (String[] row : matrix) {
    sb.append("<tr>");
    for (String col : row) {
        sb.append("<td align=center>").append(col).append("</td>");
    }
    sb.append("</tr>");
}
sb.append("</table></body></html>");
JEditorPane ep = new JEditorPane();
ep.setContentType("text/html");
ep.setText(sb.toString());
add(new JScrollPane(ep));