try {
  // do something
}
catch (Exception e) {
  throw new Exception(translate(e.getMessage()))
}

public String translate(String message) { /* translation code */ }