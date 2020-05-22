try {
    return response.readEntity(ResponseObject.class);
} catch (MappingException ex) {
    ResponseObject responseObject = new ResponseObject();
    responseObject.setFailureList(response.readEntity(new GenericType<List<Failure>>(){});
    return responseObject;
}