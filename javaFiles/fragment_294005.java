private static String uuid;

private void login() {
    // Run this only once
    if (null != uuid) return;

    ... talk to your server ...
    uuid = responseFromServer.getUuid();
}

@Test
public void testLogin() {
    login();
    assertNotNull( uuid );
}

@Test
public void someOtherTest() {
    login();

    ... test something else which needs uuid ...
}

@Test
public void testWithoutLogin() {
    ... usual test code ...
}