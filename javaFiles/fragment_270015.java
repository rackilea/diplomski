private StringBuilder puzzle;

Puzzle(String theSolution) {
    // create a buffer where all non space are turned into -
    puzzle = new StringBuilder(theSolution.replaceAll("\\S", "-"));
}