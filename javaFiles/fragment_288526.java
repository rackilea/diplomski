@WebServlet(urlPatterns = {"/slowServlet"}, asyncSupported = true)
public class SlowServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        final AsyncContext acontext = request.startAsync();
        ServletContext appScope = request.getServletContext();
        ((Executor) appScope.getAttribute("executor")).execute(() -> {
            try {
                Thread.sleep(10000); // your slow running task
                acontext.getResponse().getWriter().print("Done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}