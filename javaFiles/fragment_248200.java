public static void choosePatterns(int total, int toChoose) {
  List<Integer> indices = IntStream.range(1, toChoose + 1).mapToObj(i -> Integer.valueOf(0)).collect(Collectors.toList());
  resetIndex(indices, 0, 1, total);
  while (true) {
    System.out.println("chosen: " + indices);
    System.out.print("not chosen: ");
    for (int i = 1; i <= total; i++) {
      if (! indices.contains(Integer.valueOf(i))) {
        System.out.print(i + " ");
      }
    }
    System.out.println("\n");

    if (! incrementIndices(indices, indices.size() - 1, total)) {
      break;
    }
  }
}

public static boolean resetIndex(List<Integer> indices, int posn, int value, int total) {
  if (value <= total) {
    indices.set(posn, value);
    return posn == indices.size() - 1 ? true : resetIndex(indices, posn + 1, value + 1, total);
  } else {
    return false;
  }
}

public static boolean incrementIndices(List<Integer> indices, int posn, int total) {
  if (indices.get(posn) < total) {
    indices.set(posn, indices.get(posn) + 1);
  } else {
    int resetPosn = posn;
    do {
      if (resetPosn-- == 0) return false;
    } while (! resetIndex(indices, resetPosn, indices.get(resetPosn) + 1, total));
  }
  return true;
}

public static void main(String[] args) throws IOException {
  choosePatterns(6, 2);
}