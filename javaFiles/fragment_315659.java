public class Consumer {

    public void setResource(Resource resource) {
        DataInputStream resourceStream = new DataInputStream(resource.getInputStream());
        // ... use the stream as usual
    }

    ...
}