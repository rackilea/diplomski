VelocityEngine ve = new VelocityEngine();

ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

ve.init();