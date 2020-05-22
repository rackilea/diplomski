// ... (create ResponseBean the way as you want)
String json = new Gson().toJson(responseBean);

response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
response.getWriter().write(json);