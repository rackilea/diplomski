final Table<String, String, List<String>> values = HashBasedTable.create();
values.put("ton bon", "currency", Lists.newArrayList("ccdd","rode1","cwey","Certy"));
values.put("ton bon", "racy", Lists.newArrayList("wqadd","werde","ihtr","ytre"));

Collection<Map<String,List<String>>> obj = Collections2.transform(Collections2.filter(Arrays.asList(new String[]{"ton bon"}), Predicates.in(values.rowMap().keySet()) ), Functions.forMap(values.rowMap()));
System.out.println("Key\tValue");
for(Map<String,List<String>> item: obj){
    for(String key: item.keySet()){
        List<String> items = item.get(key);
        for(String value: items){
            System.out.println(value + "\t" + key);
        }
    }
}