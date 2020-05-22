JSONObject jsonObj = new JSONObject();
jsonObj.put("field1", climbingArea.getField1());
jsonObj.put("field2", climbingArea.getField2());

resp.setCharacterEncoding("UTF-8");
resp.setContentType("application/x-javascript");

PrintWriter out = resp.getWriter();
out.write(jsonObj.toString());
out.flush();
out.close();