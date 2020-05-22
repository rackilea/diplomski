public Object get(DataFetchingEnvironment environment) {
    Map<String, Object> context = environment.getContext();
    //get tokens, session data or whatever you need from the context to create the headers
    List headers = ...;
    return callRestWithHeaders("/rest/example", headers);
}