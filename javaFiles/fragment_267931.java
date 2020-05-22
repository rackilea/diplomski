for (int n = start; n < end; n++) {
    sum = 0;
    for (int j = 1; j < n; j++) {
        if (n % j == 0) {
            sum += j;
        }
    }

    if (sum == n) {
        perfect++;
    } else if (sum < n) {
        deficient++;
    } else {
        abundant++;
    }
}