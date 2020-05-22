List<Object[]> rows = query.list();
Map<Date, Integer> statsPerDate = new HashMap<Date, Integer>(rows.size());
for (Object[] row : rows) {
    Date date = (Date) row[0];
    Integer stat = (Integer) row[1];
    statsPerDate.put(date, stat);
}