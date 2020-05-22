System.out.print("after: ");
    for (int k = lo; k <= hi; k++) {
        System.out.print(a[k]);
        if (k == j) {
            System.out.print(" (pivot)");
        }
        System.out.print(", ");
    }
    System.out.println();
    System.out.println();