try {
    ...
} catch (InputMismatchException e) {
    // Use scan.next() to remove data from the Scanner,
    // and print it as part of error message:
    System.out.println(scan.next() + " can't be fitted anywhere.");
}