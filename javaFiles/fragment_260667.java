public Scannable scanTemporaryStorage(ScanFilters filter) {
    return filter.performOperation();
}

public enum ScanFilters {

    SCAN_RANK_GROUPS {
                @Override
                public Scannable performOperation() {
                }
            },
    SCAN_MEMBERS {

                @Override
                public Scannable performOperation() {
                }
            };

    public abstract Scannable performOperation();

}