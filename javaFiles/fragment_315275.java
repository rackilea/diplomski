/**
 * Use an order-n de-Bruijn sequence to fill a byte array such that no n-length sub-array is repeated.
 */
public static void trucatedDeBruijnBytes(int n, byte[] arr) {
    int written = generateLyndonBytes(1, 1, 256, new byte[n + 1], arr, 0);
    if (written != arr.length) {
        throw new RuntimeException("Can't generate a unique sequence of length " + arr.length + ", max is " + written);
    }
}

private static int generateLyndonBytes(int t, int p, int k, byte[] a, byte[] output, int oidx) {
    if (t == a.length) {
        if((a.length-1)%p==0) {
            int len = Math.min(p, output.length - oidx);
            System.arraycopy(a, 1, output, oidx, len);
            oidx += len;
        }
    } else {
        a[t] = a[t-p]; 
        assert a[t] < k;
        if ((oidx = generateLyndonBytes(t+1,p, k, a, output, oidx)) == output.length) {
            return oidx;
        }
        for(int j = (a[t-p] & 0xFF) + 1; j < k; j++) {
            assert(j >= 0 && j < k);
            a[t] = (byte)j;
            assert a[t] < k;
            if ((oidx = generateLyndonBytes(t+1,t, k, a, output, oidx)) == output.length) {
                return oidx;
            }
        }
    }
    return oidx;
}