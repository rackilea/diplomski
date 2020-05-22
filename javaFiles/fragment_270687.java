// The custom CL
private URLClassLoader cl;
// The previous context CL
private ClassLoader old;

@Before
public void init() throws Exception {
    // Provide the URL corresponding to the folder that contains the class
    // `javassist.MyClass`
    this.cl = new URLClassLoader(new URL[]{new File("target/classes").toURI().toURL()}){
        protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
            try {
                // Try to find the class for this CL
                return findClass(name);
            } catch( ClassNotFoundException e ) {
                // Could not find the class so load it from the parent
                return super.loadClass(name, resolve);
            }
        }
    };
    // Get the current context CL and store it into old
    this.old = Thread.currentThread().getContextClassLoader();
    // Set the custom CL as new context CL
    Thread.currentThread().setContextClassLoader(cl);
}

@After
public void restore() throws Exception {
    // Restore the context CL
    Thread.currentThread().setContextClassLoader(old);
    // Close the custom CL
    cl.close();
}


@Test
public void firstTest() throws Exception {
    SimulatedSession toUse = new SimulatedSession(false);
    Class<?> c = toUse.performThis();
    // Invoke doThis() by reflection
    Object o2 = c.newInstance();
    c.getMethod("doThis").invoke(o2);
}

@Test
public void nextTest() throws Exception {
    SimulatedSession toUse = new SimulatedSession(true);
    Class<?> c = toUse.performThis();
    // Invoke doThis() by reflection
    Object o2 = c.newInstance();
    c.getMethod("doThis").invoke(o2);
}