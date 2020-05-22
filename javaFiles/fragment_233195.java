class MyService implements ContactsService {
    @Override
    public <T extends Response> T execute(Action<T> action) {
        return (T)new GetDetailsResponse();
    }
}