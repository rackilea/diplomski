protected RequestMappingInfo createRequestMappingInfo(
        RequestMapping requestMapping, RequestCondition<?> customCondition) {

    return RequestMappingInfo
            .paths(resolveEmbeddedValuesInPatterns(requestMapping.path()))
            .methods(requestMapping.method())
            .params(requestMapping.params())
            .headers(requestMapping.headers())
            .consumes(requestMapping.consumes())
            .produces(requestMapping.produces())
            .mappingName(requestMapping.name())
            .customCondition(customCondition)
            .options(this.config)
            .build();
}