protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

    //...
    Map<Your,Types> map = (Map<Your,Types>) getServletContext()
                                .getAttribute("mySpecialMap");
    //...
}