ClassLoader cl = this.getClass().getClassLoader();
ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
try {
        Resource resources[] = resolver.getResources("classpath:Conf/*/");
} catch (IOException e) {
        e.printStackTrace();
}