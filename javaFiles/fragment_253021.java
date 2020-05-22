Configuration configuration = new Configuration();
configuration.setTemplateLoader(
            new ClassTemplateLoader(ClassInTheClasspath.class,
                            "/rootpath/under/classpath/");
configuration.setObjectWrapper(new DefaultObjectWrapper());
(...)