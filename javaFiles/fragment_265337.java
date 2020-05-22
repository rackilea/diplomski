@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    if (handler instanceof HandlerMethod) {
        HandlerMethod hm = (HandlerMethod) handler;
        RequestMapping mapping = hm.getMethodAnnotation(RequestMapping.class);
        if (mapping != null) {
            for(String val : mapping.value()) {

                //***This is the mapping value of @RequestMapping***
                System.out.println(val);
            }
        } 
    }
}