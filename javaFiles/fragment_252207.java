public static void checkDuplicate(int array []) {
  for (int i = 0; i < array.length; i++) {
    boolean found = false;
    for (int j = 0; j < i; j++)
      if (array[i] == array[j]) {
        found = true;
        break;
      }
    if (!found)
      System.out.println(array[i]);
  }
}