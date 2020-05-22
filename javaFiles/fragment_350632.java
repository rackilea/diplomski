protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter printout = response.getWriter();

        JSONObject JObject = new JSONObject(); 
        JObject.put("Response", "1"); 
        JObject.put("Message", "Client unauthorized"); 

        printout.print(JObject);
        printout.flush();
            // Or
            // printout.write(JObject.toString()); 
    }