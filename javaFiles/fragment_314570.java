try {
    assertThat("a", equalTo("a"));
    System.out.println("Title matched");
}    
catch(Error e) {
    System.out.println("Title does not match");
}