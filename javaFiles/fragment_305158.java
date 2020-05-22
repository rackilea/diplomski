//.. same as before

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return super.isReadable(type, genericType, annotations, mediaType) && hasMixInAnnotation(annotations);
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return super.isWriteable(type, genericType, annotations, mediaType) && hasMixInAnnotation(annotations);
    }
    public static boolean hasMixInAnnotation(Annotation[] annotations){
        for(Annotation annotation: annotations){
            if (annotation instanceof MixIn){
                return true;
            }
        }
        return false;
    }
}