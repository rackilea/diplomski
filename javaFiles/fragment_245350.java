ClassLoader cl = ClassLoader.getSystemClassLoader();

    URL[] urls = ((URLClassLoader) cl).getURLs();
    for (URL url : urls) {
        System.out.println(url.getFile());
    }