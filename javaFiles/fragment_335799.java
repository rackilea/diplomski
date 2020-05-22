private int hashCode;

public int hashCode() {
    int hash = hashCode;
    if (hash == 0) {
        if (count == 0) {
            return 0;
        }
        final int end = count + offset;
        final char[] chars = value;
        for (int i = offset; i < end; ++i) {
            hash = 31*hash + chars[i];
        }
        hashCode = hash;
    }
    return hash;
}