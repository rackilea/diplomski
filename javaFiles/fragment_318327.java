final Table<String, String, List<String>> values = HashBasedTable.create();
values.put("ton bon", "currency", Lists.newArrayList("ccdd","rode1","cwey","Certy"));
values.put("ton bon", "racy", Lists.newArrayList("wqadd","werde","ihtr","ytre"));
Map<String, List<String>> row = values.row("ton bon");
Map<String, String> fmap = new HashMap<String, String>();
System.out.println("Key\tValue");
for(String columnKey:row.keySet()) {
    List<String> rowValues = row.get(columnKey);
    for(String rowValue:rowValues) {
        System.out.println(rowValue + "\t" + columnKey);
        fmap.put(rowValue, columnKey);
    }
}