public void wrapper (String str) {
  while (true) {
    try {
      x(str);
    } catch (SomeException e1) {
      System.out.println("Initializing again...");
      continue;
    } catch (SomeOtherException e2) {
      System.out.println("Trying again...");
      continue;
    }
  }
}