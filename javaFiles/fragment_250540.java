* Test class annotation signifying that the tests are "integration tests" and therefore
 * require full startup in the same way as a production application. Normally used in
 * conjunction with {@code @SpringApplicationConfiguration}.
 * <p>
 * If your test also uses {@code @WebAppConfiguration} consider using the
 * {@link WebIntegrationTest} instead.