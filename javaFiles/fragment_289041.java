@Test
@Sql(scripts = "/clean_login_attempts.sql", executionPhase = AFTER_TEST_METHOD, config = @SqlConfig(dataSource = "h2Datasource", transactionManager = "h2tx"))
void loginAttemptsIncrementTheCount() throws Exception {
    unsuccessfulLoginRequest();
    unsuccessfulLoginRequest();
    unsuccessfulLoginRequest();

    LoginAttempt loginAttempt = loginAttemptService.getAttempt("admin");
    assertEquals(3, loginAttempt.getAttempt());
}