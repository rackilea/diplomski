ArrayList<String> retval = new ArrayList<Class<?>>();
PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resolver);
String basePath = ClassUtils.convertClassNameToResourcePath("com.mypackage.to.search");
Resource[] resources;
try {
    resources = resolver.getResources("classpath*:" + basePath + "/**/*.class");
} catch (IOException e) {
    throw new AssertionError(e);
}
for (Resource resource : resources) {
    MetadataReader reader;
    try {
        reader = readerFactory.getMetadataReader(resource);
    } catch (IOException e) {
        throw new AssertionError(e);
    }
String className = reader.getClassMetadata().getClassName();
retval.add(className)   
}
return retval;