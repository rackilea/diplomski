public class TypeOneFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        final AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        if (annotationMetadata.hasAnnotation(MyAnnotation.class.getName())) {
            final Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(MyAnnotation.class.getName());

            return "one".equals(attributes.get("qualifier"));
        }

        return false;
    }

}