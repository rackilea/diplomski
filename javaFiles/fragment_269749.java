private static class MyEntryPredicate implements Predicate<Map.Entry<String, List<String>>> {

    // max list length, exclusive
    private int maxLength;

    private MyEntryPredicate(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean apply(Map.Entry<String, List<String>> input) {
        return input != null && input.getValue().size() < maxLength;
    }
}