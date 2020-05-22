private Map<String, String> toMap(DTA dta) {
    Map<String, String> rv = new HashMap<>();
    rv.put("id", dta.getId());
    rv.put("age", dta.getAge());
    return rv;
}