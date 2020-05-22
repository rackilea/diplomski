DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("abc.txt"), 32 * 1024));

long start = System.nanoTime();
final int count = 220000000;
for (int i = 0; i < count; i++) {
    long l = i;
    dos.writeLong(l);
}
dos.close();
long time = System.nanoTime() - start;
System.out.printf("Took %.3f seconds to write %,d longs%n",
        time / 1e9, count);