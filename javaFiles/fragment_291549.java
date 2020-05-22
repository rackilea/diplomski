public InputStream getReport() throws Exception {
  StringBuilder urlBuilder = new StringBuilder()
      .append("http://example.com:9080/contextRoot/run")
      .append("?__report=ReportDesign.rptdesign&__format=pdf");

  if (reportParameters != null) {
    for (Map.Entry<String, String> parameter : reportParameters.entrySet()) {
      String key = StringEscapeUtils.escapeHtml(parameter.getKey());
      String value = StringEscapeUtils.escapeHtml(parameter.getValue());

      urlBuilder.append('&')
          .append(key);
          .append('=');
          .append(value);
    }
  }

  URL requestUrl = new URL(burlBuilder.toString());
  HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
  connection.setRequestMethod("GET");
  connection.setDoInput(true);
  connection.connect();

  return connection.getInputStream();
}