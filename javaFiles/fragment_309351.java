@Component
public class YourNameOfInterceptor extends HandlerInterceptorAdapter {

@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    if (handler instanceof HandlerMethod) {
        String[] requestMappingValues = ((HandlerMethod) handler).getMethodAnnotation(RequestMapping.class).value();
        for (String value : requestMappingValues) {
                //you can get values from for example @RequestMapping("/abc") here        
        }
    }

    return true;
}