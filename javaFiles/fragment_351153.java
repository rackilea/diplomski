@Provides
        VelocityEngine velocityEngine() throws Exception {
            Properties props = new Properties();
            props.put("resource.loader", "class");
            props.put("class.resource.loader.class", ClasspathResourceLoader.class.getName());
            return new VelocityEngine(props);
        }