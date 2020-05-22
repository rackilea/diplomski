Enumeration<JarEntry> entries = jar.entries();
while(entries.hasMoreElements()) {
JarEntry entry = entries.nextElement();

if(!entry.getName().endsWith(".class"))
    continue;

Class<?> clazz;
try {
    clazz = ucl.loadClass(entry.getName().replace("/", ".").replace(".class", ""));
} catch(ClassNotFoundException e) {
    e.printStackTrace();
    continue;
}

if(entry.getName().contains("$1"))
    continue;

if(clazz.getSimpleName().startsWith("CMD_"))
    set.add(clazz); //Sort the classes how you like. Here I added ones beginning with 'CMD_' to a HashSet for later manipulation