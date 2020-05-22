public class MyServlet extends javax.servlet.http.HttpServlet {

    private CobiService cobiService;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        cobiService = applicationContext.getBean(CobiService.class);
    }

}