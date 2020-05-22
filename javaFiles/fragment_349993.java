public final class HashKey {
    private final int int0, int1, int2;
    private final int hashCode;

    public HashKey(int int0, int int1, int int2) {
        this.int0 = int0;
        this.int1 = int1;
        this.int2 = int2;
        hashCode=107*int0+227*int1+499*int2;
    }

    @Override
    public final int hashCode() {
        return hashCode;
    }

    @Override
    public final boolean equals( finalObject obj) {
        if (!obj instanceof HashKey)
            retun false;
        HashKey other = (HashKey)obj;
        return int0 == other.int0 && int1 == other.int1 &&  int2 == other.int2;
    }
}