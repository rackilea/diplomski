public static void main(String[] args) {

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print("*--");
            }
            System.out.println("*");
            for (int j = 0; j <= 2; j++) {
                System.out.print("|  ");
            }
            System.out.println("|");
        }

        for (int j = 0; j <= 2; j++) {
            System.out.print("*--");
        }
        System.out.println("*");
    }