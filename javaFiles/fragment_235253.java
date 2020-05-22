public class CategoryListAddInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CategoryDao categoryDao; //for example

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

        modelAndView.getModel().put("categoryList", categoryDao.getPostCategoryList());
    }        
}