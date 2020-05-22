do {
        while (n > 0) {
            total = total + (n % 10);
            n = (n / 10);
        }
        n = total;
        total = 0;
    } while (n > 9);  // need at least 1 more loop