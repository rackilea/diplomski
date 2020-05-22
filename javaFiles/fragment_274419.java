//Print bottom half of the diamond
for (int i = 0; i < 5; i+=2) {
    if (i == 4) {
        for (int j = 0; j < (width / 2) + 1; j++)
            System.out.print(' ');
        System.out.print('*');
    } else {
        for (int j = 0; j <= i + 2; j += 2) {
            System.out.print(' ');
        } System.out.print ('*');
        for (int j = 0; j < (width / 2) - i; j++) {
            System.out.print(' ');
        } System.out.print('*');
    }
    System.out.print('\n');
}