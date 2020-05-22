String redirectURL = "http://example.com";

Map<String, String> data = new HashMap<>();
data.put("redirect", redirectURL);
String json = new Gson().toJson(data);

response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
response.getWriter().write(json);