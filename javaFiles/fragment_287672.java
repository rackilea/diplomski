String charset = "UTF-8";
String link = String.format("index.jsp?name=%s&title=%s", 
    URLEncoder.encode(metadata.getName(), charset), 
    URLEncoder.encode(metadata.getTitle(), charset));

response.sendRedirect(response.encodeRedirectURL(link));