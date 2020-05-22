public class FromUrlAndHeadersHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(FromUrlAndHeaders.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                ModelAndViewContainer mavContainer,
                NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // use the various objects here
        // request to get parameters and headers
        // mavContainer for model attributes (if you need) 
        // parameter for class type and annotation attributes
        // etc.     

        // note that the parameter class type matters, are your creating a CustomObject, a String, a DifferentClassObject, etc...
    }
}