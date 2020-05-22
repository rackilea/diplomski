public final int skipBytes(int n) throws IOException {
    int total = 0;
    int cur = 0;

    while ((total<n) && ((cur = (int) in.skip(n-total)) > 0)) {
        total += cur;
    }

    return total;
    }