public class Resource implements AutoCloseable {

    public Resource() throws Exception {
        throw new Exception("Exception from constructor");
    }

    public void doSomething() throws Exception {
        throw new Exception("Exception from method");
    }

    @Override
    public void close() throws Exception {
        throw new Exception("Exception from closeable");
    }
}