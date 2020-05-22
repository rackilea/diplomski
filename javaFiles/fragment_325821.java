Exception e = result.getException();
if (e != null) {
  try {
    throw e;
  } catch (IOException ex) {
    //handle network error here
  } catch (ServerErrorResponseException ex) {
    //handle server error response here
  } catch (Exception ex) {
    //handle RuntimeException and others here
    //(You weren't just going to ignore them, were you?)
  }
}