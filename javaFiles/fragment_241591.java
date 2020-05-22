public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter edge lenght of your rhomboid: ");
    int edgelenght = scan.nextInt();
    int k = edgelenght - 1;
    for (int i = 0; i < edgelenght; i++) {

        for (int j = 0; j < k + edgelenght; j++) {
            if (j < k) {
                System.out.print(" ");
            } else {
                System.out.print("*");
            }
        }
        k--;
        System.out.println();
    }
}