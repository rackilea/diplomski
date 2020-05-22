String resource = MyClass.class.getName().replace(".", File.separator) + ".class";      
    URL fileURL = ClassLoader.getSystemClassLoader().getResource(resource);

    String path = new File(fileURL.toURI()).getParent();
    String mySubFolder = "subFolder";
    File newDir = new File(path + File.separator + mySubFolder);
    boolean success = newDir.mkdir();