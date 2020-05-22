@Test
public void testFooRoles() throws Exception {
    Method method = Service.class.getMethod("foo");
    Annotation path = method.getDeclaredAnnotation(javax.ws.rs.Path.class);
    assertTrue(((Path) path).value().equals("/example"));

    RolesAllowed annotation = method.getDeclaredAnnotation(RolesAllowed.class);
    List<String> roles = Arrays.asList(annotation.value());
    assertEquals(2, roles.size());
    assertTrue(roles.contains("BASIC_USER"));
    assertTrue(roles.contains("ADMIN"));
}