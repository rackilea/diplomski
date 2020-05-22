if (myList.stream()
      .filter(s -> "test".equalsIgnoreCase(s))
      .findFirst()
      .isPresent()) {
    myList.add("pass");
}