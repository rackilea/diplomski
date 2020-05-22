public Properties lookupClassPathResource(String pathToResource) {
    Properties p = null;
    org.springframework.core.io.Resource r = new org.springframework.core.io.ClassPathResource(pathToResource);
    if(r.exists()) {
        try {
            p = org.springframework.core.io.support.PropertiesLoaderUtils.loadProperties(r);
        } catch (IOException e) {
            //log or wrap/rethrow exception
        }
    }
    return p;
}