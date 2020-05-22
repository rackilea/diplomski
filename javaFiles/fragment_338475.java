while (sevens > 0) {
    if (sevens%10 == 7) {
        count += 1;
    }
    sevens /= 10;
    System.out.println(sevens);
}