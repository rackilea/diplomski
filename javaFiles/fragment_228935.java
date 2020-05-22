ApplicationContext context = new ClassPathXmlApplicationContext(
            "spring/common.xml" 
    ); 

GenericApplicationContext child = new GenericApplicationContext(context);

child.getBeanFactory().registerSingleton("foo", ...);