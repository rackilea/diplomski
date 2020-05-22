public static int[] r = new int[4];
...
public static void modify(int[] array, int pos) {
    array[pos]++;
}
...
modify(MyClass.r, 1); // instead of modify(MyClass.r1);