public class UserInfoResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        // There are no null-checks here for simplicity, 
        // so don't forget to add them in production code
        return UserInfo(
            Long.parseLong(webRequest.getHeader("session-session_id")), 
            Long.parseLong(webRequest.getHeader("session-user_id")),
            webRequest.getHeader("session-user_name")
        );
    }
}