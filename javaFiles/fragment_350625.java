Map<String, String> filtered = Maps.filterValues(ADDITIONAL_QUERY, new Predicate<String>() {
    @Override
    public boolean apply(String value) {
        return value != null;
    }
});