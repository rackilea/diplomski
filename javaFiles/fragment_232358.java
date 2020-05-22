public static void main(String[] args) {
    String str = "abc";
    char[] chars = str.toCharArray();
    perm(chars, 0);
}

public static void swap(char[] x, int a, int b) {
    char tmp = x[a];
    x[a] = x[b];
    x[b] = tmp;
}

public static void perm(char[] x, int idx) {
    if (idx == x.length) {
        for (int i = 0; i < x.length; i++)
            System.out.print(x[i]);
        System.out.println();
    }

    for (int i = idx; i < x.length; i++) {
        swap(x, idx, i);
        perm(x, idx + 1);
        swap(x, idx, i);
    }
}