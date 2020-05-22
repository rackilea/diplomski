@Test
public void ensureAllClassesInPackageTempHaveAZeroArgConstructor() throws Exception {
    List<ClassLoader> classLoadersList = new LinkedList<>();
    classLoadersList.add(ClasspathHelper.contextClassLoader());
    classLoadersList.add(ClasspathHelper.staticClassLoader());

    Reflections reflections = new Reflections(new ConfigurationBuilder()
            .setScanners(new SubTypesScanner(false), new ResourcesScanner())
            .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
            .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("temp"))));

    for (Class<?> clazz : reflections.getSubTypesOf(Object.class)) {
        boolean hasZeroArgConstructor = Arrays.asList(clazz.getConstructors()).stream().anyMatch(c -> c.getParameterCount() == 0);
        if (! hasZeroArgConstructor) {
            Assert.fail(String.format("%s doesn't have a zero arg constructor", clazz.getCanonicalName()));
        }
    }
}