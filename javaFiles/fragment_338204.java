int[] a = new int[] { 7, 2, 4, 6 };
int foundAt = findItemInArray(a, 2);
if (foundAt >= 0) {
    System.out.println("Found at [" + foundAt + "]");
} else {
    System.out.println("Not found");
}

public static int findItemInArray(int[] a, int lookingFor) {
    for (int i = 0; i < a.length; i++) {
        if (a[i] == lookingFor) {
            return i;
        }
    }
    return -1;
}