protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String downloadId = "longProcess_" + request.getParameter("downloadId");
        LongProcess longProcess = (LongProcess) request.getSession().getAttribute(downloadId);
        int progress = longProcess.getProgress();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(String.valueOf(progress));
    }