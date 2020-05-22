public class CurrentUserHandlerMethodArgumentResolver
                               implements HandlerMethodArgumentResolver {

     @Override
     public boolean supportsParameter(MethodParameter methodParameter) {
          return
              methodParameter.getParameterAnnotation(ActiveUser.class) != null
              && methodParameter.getParameterType().equals(User.class);
     }

     @Override
     public Object resolveArgument(MethodParameter methodParameter,
                         ModelAndViewContainer mavContainer,
                         NativeWebRequest webRequest,
                         WebDataBinderFactory binderFactory) throws Exception {

          if (this.supportsParameter(methodParameter)) {
              Principal principal = webRequest.getUserPrincipal();
              return (User) ((Authentication) principal).getPrincipal();
          } else {
              return WebArgumentResolver.UNRESOLVED;
          }
     }
}