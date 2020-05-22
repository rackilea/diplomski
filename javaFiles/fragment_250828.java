MultivaluedMap formData = new MultivaluedMapImpl();
formData.add("name1", "val1");
formData.add("name2", "val2");
ClientResponse response = webResource
    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
    .post(ClientResponse.class, formData);