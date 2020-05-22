Arrays.sort(stockPriceAndNameSorted, new Comparator<String[]>() {
    @Override
    public int compare(final String[] entry1, final String[] entry2) {
        return Integer.valueOf(entry1[1]).compareTo(Integer.valueOf(entry2[1]));
    }
});