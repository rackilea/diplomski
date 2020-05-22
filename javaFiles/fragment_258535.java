public static int[] middle(int[] a) {
    int newLen = (a.length- 1) / 2;

    int mid[];
    if (a.length % 2 == 0) {// checking for even number
        mid = new int[2];// if even number there must be two middle number

        mid[0] = a[newLen]; // taking first middle number
        newLen++;
        mid[1] = a[newLen]; // taking second middle number
    } else {// for odd number
        mid = new int[1];// one middle number
        mid[0] = a[newLen];
    }
  return mid; 
}