try {
    JarFile jarFile = new JarFile(JAR_PATH);
    Enumeration<JarEntry> paths = jarFile.entries();
    while (paths.hasMoreElements()) {
        JarEntry path = paths.nextElement();
        if (path.isDirectory()) {
            System.out.println(path.getName());
        }
    }
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}