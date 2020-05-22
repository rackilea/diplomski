String encoding = request.getCharacterEncoding();
if (encoding == null) {
    encoding = "UTF-8";
    request.setCharacterEncoding(encoding);
}
StringBuilder query = new StringBuilder();

for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
    for (String value : entry.getValue()) {
        if (query.length() > 0) query.append("&");
        query.append(URLEncoder.encode(entry.getKey(), encoding));
        query.append("=");
        query.append(URLEncoder.encode(value, encoding));
    }
}

response.sendRedirect("http://example.com?" + query);