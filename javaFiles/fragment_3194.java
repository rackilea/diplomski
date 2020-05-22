package mycompany;

public ExeRunnerServlet extends HttpServlet {
  protected doGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
    String cmdToRunExe = //..

    // Implement exe running here..

    PrintWriter writer = res.getWriter();
    writer.append("Command has been run");
  }
}