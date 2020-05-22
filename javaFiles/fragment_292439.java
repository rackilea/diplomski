protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String radio = request.getParameter("sampleRadio");
    if (radio != null)
        System.out.println("value of selected radio: " + radio);
    else
        System.out.println("no radio button was selected");
}