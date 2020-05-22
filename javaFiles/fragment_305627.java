public static void main(String[] args) {
    Scanner lukija = new Scanner(System.in);

    int yksi = 0;
    int numero = 0;
    boolean flag = true;

    while (true) {
        int luku = Integer.valueOf(lukija.nextLine());

        if (luku == 0) {
            if (flag) {
                System.out.println("you cant count the ones");
            } else {
                break;
            }
        }

        flag = false;

        if (luku == 1) {
            yksi = yksi + 1;
        } else if (luku != 0) {
            numero = numero + 1;
        }
    }
    System.out.println(1.0 * yksi / (numero + yksi));
}