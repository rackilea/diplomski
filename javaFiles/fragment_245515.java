//Add that at top of class
private static final ClassLoader classLoader = MyClass.class.getClassLoader();

...

ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider( true);

provider.addIncludeFilter(new AssignableTypeFilter(forClass));

//Had to add this line
provider.setResourceLoader(new PathMatchingResourcePatternResolver(classLoader));

final Set<BeanDefinition> candidates = provider.findCandidateComponents(SEARCH_PACKAGE);

...