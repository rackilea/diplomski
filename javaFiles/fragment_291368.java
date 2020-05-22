for (int i = 1; i <= Output; ++i) {
        System.out.println("N= " + i);
        for (int j = 0; j < i; ++j) {
            for (int k = 0; k < i; ++k) {
                System.out.print(k < j ? " " : "*");
            }
            System.out.println();
        }
    }