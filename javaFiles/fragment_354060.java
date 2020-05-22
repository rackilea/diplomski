public static void main(String[] args) {
        int flag = 0;
        for (int i = 2; i <= 100; i++) {
            flag = 0;
            for (int j = 2; j <= i - 1; j++) {
                if (i % j != 0) {
                    flag++;
                }
            }

            if (flag == i - 2) {
                System.out.print(i + " ");
            }
        }
    }