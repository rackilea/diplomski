public static void main(String[] args) {
    Map<String, List<myStruct>> map1 = new HashMap<>();
    Map<String, List<myStruct>> map2 = new HashMap<>();

    myStruct one = new myStruct("1pm", 10);
    myStruct two = new myStruct("1pm", 5);
    myStruct thr = new myStruct("2pm", 6);
    myStruct fou = new myStruct("2pm", 2);
    myStruct fiv = new myStruct("3pm", 8);
    myStruct six = new myStruct("3pm", 1);

    map1.put("Cat", Arrays.asList(one, thr, fiv));
    map2.put("Cat", Arrays.asList(two, fou, six));

    Map<String, List<myStruct>> map3 = new HashMap<>(map1);

    List<myStruct> tmp;

    for (Map.Entry<String, List<myStruct>> e : map1.entrySet()) {
         tmp = e.getValue()
                .stream()
                .map(struct -> new myStruct(struct.time, map2.get(e.getKey())
                                                                   .stream()
                                                                   .filter(x -> x.time.equals(struct.time))
                                                                   .mapToInt(x -> struct.number / x.number)
                                                                   .findFirst().getAsInt()))
                .collect(Collectors.toList());

         map3.put(e.getKey(), tmp);
    }

    System.out.println(map3); // {Cat=[<1pm, 2>, <2pm, 3>, <3pm, 8>]}
}