List<Fruit> f = pattern.splitAsStream("Red apple, blue banana, orange")
.map(s -> {
    String[] parts = s.split(" ");
    String tmp = parts.length == 2
    ? parts[0]+"_"+parts[1]
    : s;
    return Fruit.valueOf(tmp.toUpperCase());
}).collect(Collectors.toList());