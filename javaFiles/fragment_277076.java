public class RestaurantServlet extends HttpServet{
    @Autowired
    private RestaurantService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        ac.getAutowireCapableBeanFactory().autowireBean(this);
    }
}