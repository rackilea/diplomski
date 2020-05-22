@Test
    public void with_function() {
        ParameterizedTypeReference<MyClass> typeRef = new ParameterizedTypeReference<>() {}; 
        MyClass returnValue = post("some text", typeRef, "/test");
    }
}