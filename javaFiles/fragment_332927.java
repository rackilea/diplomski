for (int x = x0, i = 0; i < 5; i++) {
    // Note x is being updated instead
    x = (a*x + c) % m;

    System.out.print(x);
}

69076