Gson gson = new Gson();
String json = gson.toJson(from);
String callback = req.getParameter("callback");

resp.setContentType("application/json");
resp.getWriter().println(callback + "(" + json + ");");