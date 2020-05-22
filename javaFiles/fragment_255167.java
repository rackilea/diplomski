try {
    Sleg illegal = new Sleg(1, 1, 90);
}
catch (IllegalArgumentException e) {
    System.out.println(e.getMessage()); // This prints something like: Invalid sleg parameters: 1
}