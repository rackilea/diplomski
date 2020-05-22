int numberOfLines = 3;
for (int i = 1; i <= numberOfLines; i++) {
    for (int j = 1; j < 2*i; j++){
        System.out.print("*");
    }
    System.out.println();
}
for (int i = numberOfLines - 1; i > 0; i--) {
    for (int j = 1; j < 2*i; j++){
        System.out.print("*");
    }
    System.out.println();
}