ResponseMessage responseMsg = this.sc.send(msg);
 DataParser parser = new JSONParser();
 String temp = parser.parseToString(responseMsg);
 httpResponse.setContentType("application/json");
 httpResponse.addHeader("Hmm","yup");
 PrintWriter out = httpResponse.getWriter();
 out.println(temp);