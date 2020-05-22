Scanner scanner = new Scanner(System.in);
System.out.print("Masukkan nilai : ");
int index = scanner.nextInt();

for (int i = 0; i < index; i++) {
    System.out.print("*");
}
System.out.println();

for (int i = 1; i < index; i++) {
    for (int j = index; j > i; j--) {
        if (j == index || j == i + 1) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }
    System.out.println();
}