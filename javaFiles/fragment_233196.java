interface Response {
    void setWhatever(String value);
}

interface Action<T extends Response> {
    T getResponse();
}

class MyAction implements Action<GetDetailsResponse> {
    @Override
    public GetDetailsResponse getResponse() {
        return new GetDetailsResponse();
    }
}

class MyService implements ContactsService {
    @Override
    public <T extends Response> T execute(Action<T> action) {
        T response = action.getResponse();
        // do something to Response here like
        response.setWhatever("some value");
        return response;
    }
}