void recurse(int[] a, int[] b, int depth) {
    if (depth == a.length) {
        System.out.println(Arrays.toString(b));
        return;
    }

    outer:
    for (int i = 0; i < a[depth]; i++) {
        for (int j = 0; j < depth; j++) {
            if (i == b[j]) {
                continue outer;
            }
        }
        b[depth] = i;
        recurse(a, b, depth + 1);
    }
}