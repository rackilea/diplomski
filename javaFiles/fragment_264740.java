int idx = i >>> 2;
int shift = (i & 3) << 3;
int mask = 0xFF << shift;
int expected2 = (expected & 0xff) << shift;
int val2 = (val & 0xff) << shift;

while (true) {
    final int num = this.array.get(idx);
    // Check that the read byte is what we expected
    if ((num & mask) != expected2) return false;
    // If we complete successfully, all is good
    final int num2 = (num & ~mask) | val2;
    if ((num == num2) || this.array.compareAndSet(idx, num, num2)) {
        return true;
    }
}