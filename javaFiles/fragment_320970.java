public class ExtendedRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo info;
        if (method.getName().startsWith("test")) {
            info = createRequestMappingInfoByMethodName(method);
        }
        else {
            info = super.getMappingForMethod(method, handlerType);
        }
        return info;
    }

    protected RequestMappingInfo createRequestMappingInfoByMethodName(Method method) {
        RequestMapping requestMapping = AnnotatedElementUtils.findMergedAnnotation(method.getDeclaringClass(), RequestMapping.class);
        String path = requestMapping.value()[0] + "/" + method.getName();
        return RequestMappingInfo
                .paths(path)
                .methods(requestMapping.method())
                .params(requestMapping.params())
                .headers(requestMapping.headers())
                .consumes(requestMapping.consumes())
                .produces(requestMapping.produces())
                .mappingName(requestMapping.name())
                .build();
    }
}