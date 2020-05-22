ResourcePatternResolver resourcePatResolver = new PathMatchingResourcePatternResolver();
Resource[] AllResources = resourcePatResolver.getResources("classpath*:files/*.txt");
 for(Resource resource: AllResources) {
    InputStream inputStream = resource.getInputStream();
    //Process the logic
 }