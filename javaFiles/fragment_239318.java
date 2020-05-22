public final class StoreKey {
    private List<Integer> keyParts;

    public static StoreKey of(int... is) {
        return new StoreKey(IntStream.of(is)
                                     .boxed()
                                     .collect(Collectors.toList()));
    }

    public StoreKey(List<Integer> keyParts) {
        this.keyParts = keyParts;
    }

    @Override
    public int hashCode() {
        return keyParts.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof StoreKey)) {
            return false;
        }

        return this.keyParts.equals(((StoreKey) obj).keyParts);
    }

}