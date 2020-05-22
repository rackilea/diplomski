ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver(new DefaultResourceLoader());
Resource[] resources = patternResolver.getResources("classpath*:META-INF/spring.xml");

for(Resource resource : resources) {
   System.out.println(resource.getDescription());
}