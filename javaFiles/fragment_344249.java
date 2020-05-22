for (int count = 1 ; count <= i.length() ; count++) {
    // Construct a temporary array with the required subset of items
    int[] tmp = new int[count];
    // Copy from the original into the temporary
    System.arraycopy(i, 0, tmp, 0, count);
    // Make a call of product()
    System.out.println(product(tmp));
}