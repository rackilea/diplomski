JarFile jar = new JarFile("res.jar");
Enumeration<JarEntry> entries = jar.entries();
while (entries.hasMoreElements()) {
    JarEntry entry = entries.nextElement();
    System.out.println(entry.getName());
}