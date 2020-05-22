public class MySuite extends Suite {
    /**
     * Called reflectively on classes annotated with <code>@RunWith(Suite.class)</code>
     * 
     * @param klass the root class
     * @param builder builds runners for classes in the suite
     * @throws InitializationError
     */
    public MySuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        this(builder, klass, getAnnotatedClasses(klass));
        // put your global setup here
        // set global variable
    }
}