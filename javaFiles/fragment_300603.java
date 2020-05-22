class Permutation {
  public static void print(ArrayList<Integer> array) {
    System.out.print("[");
    for (Integer elem: array) {
      System.out.print(elem.toString());
    }
    System.out.println("]");
  }

  public static void Permute(ArrayList<Integer> done,
                             ArrayList<Integer> remaining) {
    print(done);
    if (remaining.size() == 0) {
      return;
    }

    ArrayList<Integer> sorted = new ArrayList<Integer>(remaining);
    Collections.sort(sorted);
    for (int j = 0; j < remaining.size(); j++) {
      Integer c = sorted.get(j);
      remaining.remove(c);
      done.add(c);
      Permute(done, remaining);
      done.remove(c);
      remaining.add(0, c);
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> remaining =
      new ArrayList<Integer>(Arrays.asList(1,2,3,4));
    ArrayList<Integer> done = new ArrayList<Integer>();
    Permute(done, remaining);
  }
}