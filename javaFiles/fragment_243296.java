total = 0;
    while (n > 0) {
        total = total * 10 + n % 10;
        n = n / 10;
    }
    println("the reverse order is " + total);