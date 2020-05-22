ObjectMapper mapper = new ObjectMapper();
String json = mapper.writeValueAsString(yourObject); //yourObject must have proper getters

servletResponse.setStatus(HttpServletResponse.SC_OK);
servletResponse.getWriter().write(json);
servletResponse.getWriter().close(); //should flush on close automatically