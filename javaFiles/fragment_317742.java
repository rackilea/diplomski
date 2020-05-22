protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String action = request.getParameter("action");
    if (action.equals("save")) {
        saveData(request);
    } else if (action.equals("delete")) {
        deleteData(request);
    }
    renderPage(request, response);
}
private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // load your html file from disk
    String html = loadHtml(filename);

    // load the last data you were just editing
    String a=request.getParameter("regs_numb") // or whatever you primary key field id
    Map<String,String> model = loadSqlData(a);

    // inject the data into your html
    for(Entry<String,String> entry : model.entrySet()) {
        html = html.replace("${" + entry.getKey() +"}", entry.getValue());
    }

    // send the page to the browser
    response.getWriter().println(html);
    response.flush();
}