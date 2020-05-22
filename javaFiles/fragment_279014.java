Set<Table1> found = new HashSet<Table1>();
for (Table1 t1 : set) {
    if (t1.getTable2().getTable3().getLang().equals(theLang)) {
        found.add(t1);
    }
}