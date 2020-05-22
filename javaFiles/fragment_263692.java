public class MyClass<T> {
    private Class<T> responseClass;

    public MyClass(final Class<T> responseClass) {
        super();
        this.responseClass = responseClass;
    }

    public void getApiResponse(final String response) {

        final ObjectMapper mapper = new ObjectMapper();
        final T values = mapper.readValue(response, responseClass);

        //more code here
    }
}