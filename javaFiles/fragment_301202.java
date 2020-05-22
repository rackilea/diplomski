int a[] = new int[30];
for (int i = 0; i < a.length; ++i) {
    // Outer update ----------^^^

    a[i] = (int) (Math.random() * 36) + 1;
    for (int j = 0; j < i; ++j) {
        // Inner update ---^^^

        if (a[i] == a[j]) {
            --i;
            break; // <==== This break
        }
    }
}

for (int num : a) {
    System.out.print(num + " ");
}
System.out.println();