<%
// Fetch the data
URL url = new URL("https://myurl.azurewebsites.net/.auth/me");

Cookie cookie = null;
Cookie[] cookies = request.getCookies();

HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
for(int i=0; i < cookies.length; i++) {
   cookie = cookies[i];
   connection.addRequestProperty(cookie.getName(), cookie.getValue());

}
Enumeration<String> headNames = request.getHeaderNames();
while(headNames.hasMoreElements()) {
    String headerName = headNames.nextElement();
    String headerVal = request.getHeader(headerName);
    connection.addRequestProperty(headerName, headerVal);
}

out.println("generate connection.....");

connection.connect();

IOUtils.copy(new InputStreamReader(connection.getInputStream()),out);

%>