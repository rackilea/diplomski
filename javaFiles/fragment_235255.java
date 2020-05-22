@Override
public void postHandle(HttpServletRequest request,
                       HttpServletResponse response,
                       Object handler,
                       ModelAndView modelAndView) throws Exception {

    request.setAttribute("categoryList", categoryDao.getPostCategoryList());
}