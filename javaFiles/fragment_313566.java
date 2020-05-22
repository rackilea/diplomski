public static void main(String[] args) {
    int[] p = {5, 2, 2, 5, -1, 5, 12, 2, 5, 44, 12, 9};
    remove(p);
}

static public void remove(int[] a) {
    for (int i = 0; i < a.length; i++) {
        boolean found = false;
        for (int j = i + 1; j < a.length; j++) {
            if (a[i] == a[j]) {
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println(a[i]);
    }

}