public class Hasho {

    private static final Long LARGE_PRIME =  948701839L;
    private static final Long LARGE_PRIME2 = 6920451961L;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " -> " + hash(i));
        }
    }

public static int hash(int i) {
    // Spread out values
    long scaled = (long) i * LARGE_PRIME;

    // Fill in the lower bits
    long shifted = scaled + LARGE_PRIME2;

    // Add to the lower 32 bits the upper bits which would be lost in
    // the conversion to an int.
    long filled = shifted + ((shifted & 0xFFFFFFFF00000000L) >> 32);

    // Pare it down to 31 bits in this case.  Replace 7 with F if you
    // want negative numbers or leave off the `& mask` part entirely.
    int masked = (int) (filled & 0x7FFFFFFF);
    return masked;
    }
}