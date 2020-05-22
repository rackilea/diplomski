Method method = resourceInfo.getResourceMethod();
Class cls = resourceInfo.getResourceClass();
String[] mediaTypes;
Produces produces = method.getAnnotation(Produces.class);
if (produces == null) {
    produces = cls.getAnnotation(Produces.class);
}
if (produces != null) {
    mediaTypes = produces.value();
} else {
    mediaType = defaultMediaTypes;
}