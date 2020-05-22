public class CurrentUserWebArgumentResolver implements WebArgumentResolver{

   Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) {
        if(methodParameter is for type User && methodParameter is annotated with @ActiveUser) {
           Principal principal = webRequest.getUserPrincipal();
           return (User) ((Authentication) principal).getPrincipal();
        } else {
           return WebArgumentResolver.UNRESOLVED;
        }
   }
}