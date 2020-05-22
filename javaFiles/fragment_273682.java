@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Map<String, String> messages = new HashMap<String, String>();
    String name = request.getParameter("name");
    if (name.trim().isEmpty()) {
        messages.put("name", "give a name");
    }

    //handle messages in each jsp separately
    if (messages.isEmpty()) {
        messages.put("noErrors", String.format("Welcome blabla"));
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("greatSucceess.jsp").forward(request, response);
    }else{
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("form.jsp").forward(request, response); 
    } 
}