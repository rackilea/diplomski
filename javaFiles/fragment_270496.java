public class RequestInterceptor extends HandlerInterceptorAdapter {
    @Override
        public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {

            // logic here that checks if the user can see something
            modelAndView.addObject("canUserSeeSection", abooleanvalue);

            super.postHandle(request, response, handler, modelAndView);
        }
    }
}