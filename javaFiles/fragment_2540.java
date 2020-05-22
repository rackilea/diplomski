public static int [] linearSearch(double[] list, double key) {
    int[] indices = int[list.length];
    int n = 0;
    for (int i = 0; i < list.length; i++) {
      if (key == list[i]){
        îndices[n++] = i;
      }
    }
    int[] result = new int[n];
    for (int i = 0; i < n; ++i) {
        result[i] = indices[i];
    }
    return result;
  }