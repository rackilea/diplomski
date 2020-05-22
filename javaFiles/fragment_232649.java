for (Entry<Predicate<Integer>, Grade> entry : table.entrySet()) {
    if (entry.getKey().test(marks)) {
        return entry.getValue();
    }
}
return Grade.GREATEST;