MyRequest req = new MyRequest();
req.setFirstname("john");
req.setLastname("doe");
req.setAge(30);

MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get(path).contentType(MediaType.APPLICATION_JSON);

for (PropertyDescriptor property : new BeanWrapperImpl(req).getPropertyDescriptors()) {
    if (property.getWriteMethod() != null) {
        requestBuilder.param(property.getName(),     
                property.getReadMethod().invoke(req).toString());
    }
}

mvc.perform(requestBuilder).andExpect(status().isOk());