for (int i = 0; i < args.length; i++) {
    for (int j = 0; j < args.length; j++) {
        // first print a separator if not the first element on the line
        if (j > 0) System.out.print(" ");

        // now print either the j-th arg or a "-"
        if (j == i) {
            System.out.print("-");
        } else {
            System.out.print(args[j]);
        }
    }
    System.out.println();
}