public interface A {
    void someMethod() throws IOException, MalformedURLException;
}

class AImpl implements A {
    @Override
    public void someMethod() throws IOException, MalformedURLException {
        // here goes your business logic
    }
}

class ErrorHandlerOne implements A {

    @Override
    public void someMethod() throws IOException {
        try {
            delegate.someMethod();
        } catch (MalformedURLException e) {
            // handle the exception
        }
    }
}