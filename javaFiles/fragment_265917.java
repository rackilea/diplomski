public static boolean contains(int[] arr, int val) {

    for (int i : arr) {
      if (i == val) {
        return true;
      }
    }
    return false;
  }

  public static int sum(int[] arr) {

    int sum = 0;
    for (int i : arr) {
      sum += i;
    }
    return sum;
  }

  public static int[] removeElem(int index, int[] arr) {

    int[] retArr = new int[arr.length - 1];
    for (int i = 0; i < index; i++) {
      retArr[i] = arr[i];
    }
    for (int i = index + 1; i < arr.length; i++) {
      retArr[i - 1] = arr[i];
    }
    return retArr;
  }

  public static int[] getArr(int[] arr, int[] forbidden) {

    if (arr.length == 1) {
      if (!contains(forbidden, arr[0]))
        return arr;
      else
        return null;
    }
    else {
      if (contains(forbidden, sum(arr))) {
        return null;
      }
      else {
        for (int i = 0; i < arr.length; i++) {
          int[] retArr = getArr(removeElem(i, arr), forbidden);
          if (retArr != null) {
            int[] newArr = new int[arr.length];
            for (int j = 0; j < retArr.length; j++) {
              newArr[j] = retArr[j];
            }
            newArr[newArr.length - 1] = arr[i];
            return newArr;
          }
        }
      }
    }
    return null;
  }

  public static void main(String[] args) throws IOException {

    int[] a = { 1, 3, 7, 9 };
    int[] b = { 4, 19, 16 };

    System.out.println("input array a: " + Arrays.toString(a));
    System.out.println("forbidden sum array b: " + Arrays.toString(b));
    System.out.println(Arrays.toString(getArr(a, b)));
  }