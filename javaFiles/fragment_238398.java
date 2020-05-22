@ControllerAdvice
@RequiredArgsConstructor
@Order(HIGHEST_PRECEDENCE)
public class ServletRequestBinderRequestBodyAdvice extends RequestBodyAdviceAdapter {

    private final ServletRequest servletRequest;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        copyDefaultPropertiesThatWhereOverwritenWithNull(parameter, body);

        new ExtendedServletRequestDataBinder(body).bind(servletRequest);

        return body;
    }

    private void copyDefaultPropertiesThatWhereOverwritenWithNull(MethodParameter parameter, Object arg) {
        Object argWithDefaults = instantiateClass(parameter.getParameterType());
        copyPropertiesSkippingNulls(argWithDefaults, arg);
    }

}