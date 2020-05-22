/** 
     * @inherited <p>
     */
    @Override
    public void toggleSortOrder(int column) {
        List<? extends SortKey> sortKeys = getSortKeys();
        if (sortKeys.size() > 0) {
            if (sortKeys.get(0).getSortOrder() == SortOrder.DESCENDING) {
                setSortKeys(null);
                return;
            }
        }
        super.toggleSortOrder(column);
    }