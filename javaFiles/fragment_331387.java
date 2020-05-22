public String handleRequest(HttpServletRequest request) {    
   try {
       request.setCharacterEncoding("UTF-8");
       String shortname = request.getParameter("shortname");

       (...)
   }
   catch (UnsupportedEncodingException e) {
       // ...
   }
}