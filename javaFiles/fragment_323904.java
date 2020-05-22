@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   if ("PATCH".equals(request.getMethod())) 
        doPatch(request, response);
        return;
   }
   super.service(request, response); 
}