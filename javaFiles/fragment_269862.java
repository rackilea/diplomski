long begin = System.nanoTime();
for (int i = 0; i < 100000; i++) {
    goldschmidt(1.0, 0.0); // changed this for restoringDivision(1) to test your code
}
long end = System.nanoTime();
System.out.println(TimeUnit.NANOSECONDS.toMillis(end - begin) + "ms");