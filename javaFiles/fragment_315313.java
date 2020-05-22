public static void main(String[] args) throws Exception {
        Set<Class<?>> classes = new HashSet<>();

        URL jarUrl = new URL("file:///C:/app/folder/jar/file.jar");
        URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl});
        JarFile jar = new JarFile("C:\\app\\folder\\jar\\file.jar");

        for (Enumeration<JarEntry> entries = jar.entries(); entries.hasMoreElements(); )
        {
            JarEntry entry = entries.nextElement();
            String file = entry.getName();

            if (file.endsWith(".class"))
            {

                String classname =
                        file.replace('/', '.').substring(0, file.length() - 6).split("\\$")[0];
//                System.out.println(classname);

                try {
                    Class<?> c = loader.loadClass(classname);
                    classes.add(c);
                } catch (Throwable e) {
                    System.out.println("WARNING: failed to instantiate " + classname + " from " + file);
                }
            }
        }
        Map<String, List<Method>> collected =
                classes.stream().collect(Collectors.toMap(Class::getName, clz -> {
                    List<Method> methods = new ArrayList<>(Arrays.asList(clz.getDeclaredMethods()));
                    methods.addAll(Arrays.asList(clz.getMethods()));
                    return methods;
                }));

        collected.forEach((clz, methods) -> System.out.println("\n" + clz + "\n\n" + methods));
    }