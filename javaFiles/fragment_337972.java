protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String processId = "longProcess_" + request.getParameter("processId");
    LongProcess longProcess = (LongProcess) request.getSession().getAttribute(processId);
    int progress = longProcess.getProgress();

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(String.valueOf(progress));
}