char odd = '$';
    char even = '£';
    int amount = 6;

    for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < i; j++) {
            System.out.print(i % 2 == 0 ? even : odd);
        }
    }