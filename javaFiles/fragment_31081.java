public class DatabaseClassLoader extends ClassLoader {

    public DatabaseClassLoader(ClassLoader parent, ... /* connection to database */ ) {
       super(parent);
       // store the connection
    }

    public Class findClass(String name) {
       byte[] data = loadDataFromDatabase(name);
       return defineClass(name, data, 0, data.length);
    }
    private byte[] loadDataFromDatabase(String name) {
        // this is your job.
    }
}