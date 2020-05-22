public class Client<T extends Response> {
    private Class<T> clazz;
    public Client(Class<T> clazz) {
        this.clazz = clazz;
    }
    public T readResponse() {
        ObjectMapper mapper = new ObjectMapper();

        return (T) mapper.readValue(data, clazz);
    }
}