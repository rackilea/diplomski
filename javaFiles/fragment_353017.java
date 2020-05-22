int count = 0, total = 0, start = 200;
for (; count < 16; start++) {
    boolean mod13 = start % 13 == 0, mod17 = start % 17 == 0;
    if (mod13 ^ mod17) {
        if (count > 0) {
            if (count % 4 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
        total += start;
        System.out.printf("% 9d", start);
        count++;
    }
}
System.out.printf("%nTotal = %d%n", total);