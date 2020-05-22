public class CustomURLStreamHandlerFactory implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        if ("customuri".equals(protocol)) {
            return new CustomURLStreamHandler();
        }

        return null;
    }

}