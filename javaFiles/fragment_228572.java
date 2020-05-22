public static boolean contains(final char[] array, final char[] target){
    // check that arrays are not null omitted
    if (target.length == 0) {
      return true;
    }
    outer:
    for (int i = 0; i < array.length - target.length + 1; i++) {
      for (int j = 0; j < target.length; j++) {
        if (array[i + j] != target[j]) {
          continue outer;
        }
      }
      return true;
    }
    return false;
}