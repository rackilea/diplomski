Map<T,HandlerMethod> map = this.handlerMapping.getHandlerMethods();
HandlerMethod handlerMethod = map.get('some T');
Method annotatedMethod = handlerMethod.getMethod();
Annotation documentedRequestMappingAnnotation = AnnotationUtils.findAnnotation(annotatedMethod, DocumentedRequestMapping.class);
Map<String, Object> annotationValues = Annotationutils.getAnnotationAttributes(documentedRequestMappingAnnotation);
annotationValues.get("documentation");