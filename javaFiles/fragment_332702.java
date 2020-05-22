int[] a = {10, 20, 30, 40, 40};
int max = Arrays.stream(a).max().getAsInt();
for (int i = 0; i < a.length; i++) {
      if (a[i] == max) {
        System.out.print(max + " " + i);
     }
}