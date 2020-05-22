Map<String,Map<Integer,Double>> originalMap = new HashMap<>();
Map<Integer,Double> inner1 = new HashMap<>();
Map<Integer,Double> inner2 = new HashMap<>();
Map<Integer,Double> inner3 = new HashMap<>();
originalMap.put("aa",inner1);
originalMap.put("bb",inner2);
originalMap.put("cc",inner3);
inner1.put(10,10.0);
inner1.put(20,20.0);
inner1.put(30,30.0);
inner2.put(10,40.0);
inner2.put(20,50.0);
inner2.put(30,60.0);
inner3.put(10,70.0);
inner3.put(20,80.0);
inner3.put(30,90.0);

Map<Integer,Map<String,Double>> out =
    originalMap.entrySet()
               .stream()
               .flatMap(e -> e.getValue()
                              .entrySet()
                              .stream()
                              .map(e2 -> {
                                  Map<String,Double> m = new HashMap<>();
                                  m.put(e.getKey(),e2.getValue());
                                  return new SimpleEntry<>(e2.getKey(),m);}))
               .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1,v2)->{v1.putAll(v2);return v1;}));
System.out.println (out);