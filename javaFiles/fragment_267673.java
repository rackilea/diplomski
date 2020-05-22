public PersonDetails(String initialName, int initialAge) {
    if (initialName.equals("Stephen")) {
      name = initialName;
    }
    else {
      System.out.println("Access denied");
      System.exit(0);
    }

    if (initialAge >= 18) {
      age = initialAge;
    }
    else {
      System.out.println("You are a child");
      System.exit(0);
    }
  }