public static void main(String[] args) {

    String[] strs = new String[]{"a", "b", "c", "d"};
    int[] indices = {3, 1, 2, 0};

    String tmp;
    for (int i = 0; i < strs.length; i++) {
        if (i != indices[i]) {
            tmp = strs[i];
            strs[i] = strs[indices[i]];
            strs[indices[i]] = tmp;

            indices[indices[i]] = indices[i];
            indices[i] = i;
        }
    }

    for (int i : indices) {
        System.out.print(i + " ");
    }
    System.out.println();
    for (String str : strs) {
        System.out.print(str + " ");
    }
}