public class MyRestParamsArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(MyRestParams.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, 
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        MyRestParams restParam = new MyRestParams();
        restParam.setReq((HttpServletRequest) webRequest.getNativeRequest());

        return restParam;
    }
}