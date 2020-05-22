public class HomeInterceptor extends HandlerInterceptorAdapter {

    /** The controller instance returning the view for the landing page. */
    private final CustomHomeController customHomeController;

    @Autowired
    public HomeInterceptor(CustomHomeController customHomeController) {
        this.customHomeController = customHomeController;
    }

    /**
     * Swaps the {@link ModelAndView} to the one returned by
     * {@link CustomHomeController#landingPage(ModelMap) }.
     * The controller performs no checking if the model and view is
     * actually one for the landing page. The correct setup
     * has to be ensured by the configuration.
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Manually call the Controller custom home
        // If necessary, also request can be forwarded
        customHomeController.landingPage(modelAndView.getModelMap());
    }
}