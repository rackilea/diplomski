@Test
public void should_set_email() throws Exception {
    // when:
    interact(() -> {
        controller.setEmail("test@gmail.com");
    });

    // then:
    verifyThat("#email", hasText("test@gmail.com"));
}