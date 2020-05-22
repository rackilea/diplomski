Map<String,CommonInterface> myMap = new HashMap<>();
myMap.put("one", new One());
myMap.put("two", new Two());
for (Map.Entry<String,CommonInterface> e : myMap.entrySet()) {
    System.out.println(e.getKey());
    CommonInterface c = e.getValue();
    c.commonMethod(123);
}