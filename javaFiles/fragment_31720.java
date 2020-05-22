for (int i = 1; i <= n;) {
    for (int j = 2; j <= Math.sqrt(num); j++) {
        if (num % j == 0) {
            status = 0;
            break;
        }
    }
    if (status == 0) {
        System.out.print(num + " ");
        i++;
        count++;
    }
    status = 1;
    num++;

    if (count == 5) {
        System.out.println();
        count = 0;
    }
}