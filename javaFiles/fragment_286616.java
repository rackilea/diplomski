AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

    ctx.register(AppConfig.class);
    ctx.refresh();

    BeanDefinition javaConfigBeanDefinition = ctx.getBeanDefinition("a");
    System.out.println("Creation class for a=" + javaConfigBeanDefinition.getResourceDescription());

    BeanDefinition xmlBeanDefinition = ctx.getBeanDefinition("xmlBean");
    System.out.println("Creation XML file for xmlBean=" + xmlBeanDefinition.getResourceDescription());