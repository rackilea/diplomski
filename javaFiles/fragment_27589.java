String language = (String) request.getAttribute("language");
<% if(language != null) {
    out.print("<html lang=\"" + language + "\">");
} else {
    out.print("<html lang=\"en\">");
}
%>