public int hashCode() {
    if (hash == 0 && count > 0) { //(1)
        int h = hash;
        int off = offset;
        char val[] = value;
        int len = count;

        for (int i = 0; i < len; i++) {
            h = 31*h + val[off++];
        }
        hash = h;
    }
    return hash; //(2)
}