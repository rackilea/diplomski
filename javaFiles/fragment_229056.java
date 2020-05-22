public static Tree<String> readFromFile(Path file) throws FileNotFoundException {
  try (Scanner input = new Scanner(file)) {
    Tree<String> tree = new Tree<>();
    while(input.hasNext()) {
      tree.insert(input.next());
    }
    return tree;
  }
}