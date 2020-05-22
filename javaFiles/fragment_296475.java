new MockUp<RestTemplate>() {
    @Mock
    <T> T getForObject(String url, Class<T> responseType, Object... urlVariables) {
        return (T) "{(\"error\": \"missing data id\", \"data_id\":2001)}";
    }
};