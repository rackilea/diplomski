long start = System.getNanos() / 1000000;
long end = start;
while (end - start < 3000) {
    ...
    end = System.getNanos() / 1000000;
}