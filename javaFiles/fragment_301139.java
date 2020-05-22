class Foo {
  public static void main(String[] args) {
    int[] ints = {1, 2, 3};
    List<Integer> intList = new ArrayList<Integer>();
    for (int index = 0; index < ints.length; index++)
    {
        intList.add(ints[index]);
    }
  }
}