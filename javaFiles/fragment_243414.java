public class PagePopulationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null) {
            User user = userService.findOne(request);
            modelAndView.addObject("myUserProfile", user);
        }
    }

}