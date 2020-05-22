interface MyDataWebServiceInterface {
    List<String> requestData();
}

class MyDataWebService implements MyDataWebServiceInterface {
    public MyDataWebService(String request) {
    }

    @Override
    public List<String> requestData() {
        return Arrays.asList("foo", "bar");
    }
}