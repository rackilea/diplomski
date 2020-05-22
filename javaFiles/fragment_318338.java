@Test
public void shouldCreateAuthFromColonSeparated() {
    Auth auth = authFactory.create("johnny@example.com:secret");
    assertThat(auth.getEmail(), is("johnny@example.com"));
    assertThat(auth.getPassword(), is("secret"));
}