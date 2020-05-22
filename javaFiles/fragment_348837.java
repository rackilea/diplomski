int num = 1;
for (int n = 1; n < 12; n++) {
    if (n > 8) {
        System.out.println(n + 118);
    } else if (n % 3 == 0) {
        System.out.println(num + 1);
    } else {
        num *= 2;
        System.out.println(num);
    }
}