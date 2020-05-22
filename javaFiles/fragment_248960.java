@Test
  public void shouldThrowSomeException() {
        String errorMessage = "";
        try {
            Result result = service.method("argument");
        } catch (SomeException e) {
            errorMessage = e.getMessage();
        }
        assertTrue(errorMessage.trim().equals(
                "ExpectedMessage"));
  }