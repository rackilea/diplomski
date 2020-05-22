private String warpWithHtmlTags(String...strings) {

    StringBuilder sb = new StringBuilder("<html>");
    sb.append("<div style = \"text-align: center;\">");

    for(String s : strings) {

        sb.append("<p>")
          .append(s)
          .append("</p>");
    }

    sb.append("</div></html>");
    return sb.toString();
}