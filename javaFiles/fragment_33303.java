long start = System.currentTimeMillis();
long end;
for (int i = 1; i <= 8000000; i++) {
    if (i % 1000000 == 0) {
        end = System.currentTimeMillis();
        System.out.println(i);
        System.out.println((end-start));
        start = end;
    }
}