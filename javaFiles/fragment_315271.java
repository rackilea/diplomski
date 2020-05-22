Random rnd = new Random();

int[] a = new int[200];
for (int i = 0; i < a.length; i++)
    a[i] = i;

int[] r = new int[15];
for (int i = 0; i < r.length; i++) {
    int j = rnd.nextInt(a.length - i);
    r[i] = a[j];
    a[j] = a[a.length - i - 1];
}