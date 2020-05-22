URLClassLoader child = new URLClassLoader(
        new URL[] {myJar.toURI().toURL()},
        this.getClass().getClassLoader()
);
Class classToLoad = Class.forName("com.MyClass", true, child);
Method method = classToLoad.getDeclaredMethod("myMethod");
Object instance = classToLoad.newInstance();
Object result = method.invoke(instance);