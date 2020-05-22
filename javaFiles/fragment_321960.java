public int hashCode() {
    int h = hash;
        int len = count;
    if (h == 0 && len > 0) {
        int off = offset;
        char val[] = value;

            for (int i = 0; i < len; i++) {
                h = 31*h + val[off++];
            }
            hash = h;
        }
        return h;
    }