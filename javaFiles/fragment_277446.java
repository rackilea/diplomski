public static void main(String[] args) {

    String str = "104,Jeans,B&B,pretty 105,Shoes,Nike,nice";
    final String[] lines = str.split(" ");

    StringBuilder buf = new StringBuilder();
    buf.append("<html>" + "<body>" + "<table>" + "<tr>" + "<th>Number</th>" + "<th>Name</th>" + "<th>Maker</th>" + "<th>Description</th>" + "</tr>");

    for (String line : lines) {
        buf.append("<tr><td>")
                .append(line)
                .append("</td><td>");
    }
    buf.append("</table>" + "</body>" + "</html>");
    System.out.println(buf);
}