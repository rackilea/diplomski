public class Test {
  Integer[] a = {00, 11, 11, 22, 33, 44, 55, 55, 66, 77, 88, 99};
  int nElems = a.length;

  public void dups() {
    int[] b = new int[100];
    int[] c = new int[100];

    int k = 0;
    int n = 0;
    int p = 0;

    for (int i = 0; i < nElems; i++) {
      for (int j = i + 1; j < nElems; j++) {
        if (a[j].equals(a[i])) {
          b[k++] = j;
        }
      }
    }

    for (int l = 0; l < k; l++) {
      System.out.print(b[l] + " ");
    }
    for (int m = 0; m < nElems; m++) {
      if (m != b[p]) {
        c[n++] = a[m];
      } else {
        p += 1;
      }
    }

    System.out.print("\n");

    for (int o = 0; o < nElems - k; o++) {
      System.out.print(c[o] + " ");
    }
  }

  public static void main(String args[]) {
    new Test().dups();
  }
}