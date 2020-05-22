public class ElementNotFoundException extends Exception {
  ...
}

public String getSomething() {
  if (something == null) {
    throw new ElementNotFoundException();
  } else {
    return something;
  }

}