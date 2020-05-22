Enumeration<URL> resources = Main.class.getClassLoader().getResources("client.xml");
    while (resources.hasMoreElements()){
        URL url = resources.nextElement();
        File file = new File(url.getFile());
        FileInputStream input = new FileInputStream(file);
        System.out.println(input);
    }