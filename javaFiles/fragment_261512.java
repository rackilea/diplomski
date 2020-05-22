if (k - 1 > 0 && matrix[k - 1][l + 2] == matrix[k + 1][l + 2]) {
    counter += 1;
    StdOut.println(counter);
} else if (k - 1 > 0 && matrix[k - 1][l + 2] == matrix[k + 1][l - 2]) {
    counter += 1;
    StdOut.println(counter);
}