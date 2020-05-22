public void valid() throws InterruptedException {
  try {
    System.in.wait(5) //Just an example
  } catch (InterruptedException exception) {
    exception.printStackTrace();
    throw exception;
  }
}

// Note the lack of a "throws" clause.
public void invalid() {
  try {
    System.in.wait(5) //Just an example
  } catch (InterruptedException exception) {
    exception.printStackTrace();
    throw exception;
  }
}