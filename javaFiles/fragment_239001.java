public void search() {
    String[] arrayString = new String[]{
      "Administrator",
      "Vale.Vicky",
      "Lane.Lois",
      "Kent.Clark",
      "Wayne.Bruce",
      "Parker.Peter",
      "Rogers.Steve",
      "Luther.Lex",
      "Osborn.Harry",
      "Tony.Stark"};
    String searchString = "Rogers.Steve";

    Arrays.sort(arrayString);
    System.out.println(Arrays.binarySearch(arrayString, searchString));
}