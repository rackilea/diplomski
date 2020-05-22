protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    AsyncContext actx = req.startAsync();
    actx.getResponse().getWriter().write("retry: 36000000000\r\n"); // 10000 hours!
    actx.getResponse().getWriter().flush();
    //save actx and use it when we need sent data to the client.
}