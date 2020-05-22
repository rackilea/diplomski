String subject = URLEncoder.encode("my subject", "utf-8").replace("+", "%20");
String body = URLEncoder.encode("S&D", "utf-8").replace("+", "%20");
// Email addresses may contain + chars
String email = "test@example.com".replace("+", "%2B");
String link = String.format("mailto:%s?subject=%s&body=%s", email, subject, body);
System.out.println(StringEscapeUtils.escapeHtml(link));