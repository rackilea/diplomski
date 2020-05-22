for (int i = 0; i < 10; i++) {
    System.out.format("%2d -%3d | ", i * 10 + 1, i * 10 + 10);
    for (int j = 0; j < counts[i] / 5; j++)
        System.out.print("*");
    System.out.println();
}