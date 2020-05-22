public class ValidModifyingVerbMethodArgumentResolver extends ModelAttributeMethodProcessor {

    private String requestMethod;

    /**
     * @param annotationNotRequired if "true", non-simple method arguments and
     *                              return values are considered model attributes with or without a
     *                              {@code @ModelAttribute} annotation.
     */
    public ValidModifyingVerbMethodArgumentResolver(final boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return super.supportsParameter(parameter) && parameter.hasParameterAnnotation(ValidModifyingVerb.class);
    }

    @Override
    protected void bindRequestParameters(final WebDataBinder binder, final NativeWebRequest request) {
        HttpServletRequest servletRequest = request.getNativeRequest(HttpServletRequest.class);
        requestMethod = servletRequest.getMethod();
        if (isModifyingMethod(requestMethod)) {
            ((ServletRequestDataBinder) binder).bind(servletRequest);
        }
    }

    @Override
    protected void validateIfApplicable(final WebDataBinder binder, final MethodParameter parameter) {
        if (isModifyingMethod(requestMethod)) {
            super.validateIfApplicable(binder, parameter);
        }
    }

    private boolean isModifyingMethod(String method) {
        return !"GET".equals(method);
    }
}