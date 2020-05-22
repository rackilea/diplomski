public Class<?> loadAllJarClasses(String pathToJar, String mainClassName) {

        Class<?> clazz = null;
        Class c;

        try {

            JarFile jarFile = new JarFile(pathToJar);
            Enumeration<JarEntry> e = jarFile.entries();

            URL[] urls = { new URL("jar:file:" + pathToJar + "!/") };
            URLClassLoader cl = URLClassLoader.newInstance(urls);

            while (e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }
                // -6 because of .class
                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                logger.info("loading " + className);
                c = cl.loadClass(className);
                resgisterBean(c);
                logger.info("loaded " + className);
                if (className.equalsIgnoreCase(mainClassName))
                    clazz = c;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clazz;
    }

    public void resgisterBean(Class<?> clazz) {

         beanFactory = (BeanDefinitionRegistry) ((ConfigurableApplicationContext) ctx)
                .getBeanFactory();

        beanFactory.registerBeanDefinition(clazz.getName(),
                BeanDefinitionBuilder.genericBeanDefinition(clazz).getBeanDefinition());
    }