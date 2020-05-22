public static void main(String ...args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "C://fullyQualifiedPathTo//a1.xml"
        );
        System.out.println(ctx.getBean("injectedAnnotatedCollection"));
    }