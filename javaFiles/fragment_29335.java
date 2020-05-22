for (int c0 = 0; c0 < N; c0++) {
    System.out.print(getSpaces(N - c0));
    System.out.print("*");
    System.out.print(getSpaces(c0 * 2));
    System.out.print("*");
    System.out.println();
}
for (int c0 = 1; c0 <= N; c0++) {
    System.out.print(getSpaces(c0));
    System.out.print("*");
    System.out.print(getSpaces((N - c0) * 2));
    System.out.print("*");
    System.out.println();
}