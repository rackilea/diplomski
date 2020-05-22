@Override
protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{ 
    // pre-flight request processing
    resp.setHeader("Access-Control-Allow-Origin", "*");
    resp.setHeader("Access-Control-Allow-Methods", SUPPORTED_METHODS);
    resp.setHeader("Access-Control-Allow-Headers", SUPPORTED_HEADERS);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
   resp.setHeader("Access-Control-Allow-Origin", "*");
   resp.setContentType("application/json");

   // implementation...
}