public class FilelistSuite extends Suite {
    public FilelistSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        super(klass, loadFromFile(klass));
    }

    private static Class<?>[] loadFromFile(Class<?> klass) throws InitializationError {
        // get annotation
        SuiteclassesFile annotation = klass.getAnnotation(SuiteclassesFile.class);
        if (annotation == null) {
            throw new InitializationError(String.format("class '%s' must have a SuiteclassesFile annotation", klass.getName()));
        }

       try {
            return fromFile(annotation.filename());
        } catch (RuntimeException e) {
            throw new InitializationError(e.getCause());
        }
    }

    // read file to extract test class names
    private static final Class<?>[] fromFile(String filename) throws RuntimeException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines
                    .map(FilelistSuite::forName)
                    .toArray(Class[]::new);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    // wrap Class.forName to be able to use it in the Stream
    private static final Class<?> forName(String line) throws RuntimeException {
        try {
            return Class.forName(line);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // new annotation for your test suite
    public @interface SuiteclassesFile {
        public String filename();
    }
}