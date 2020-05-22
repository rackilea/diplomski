List<Drink> list = new ArrayList<>();
list.add(new Drink("coke", 30));
list.add(new Drink("fanta", 10));
list.add(new Drink("coke", 5));
list.add(new Drink("sprite", 1));
list.add(new Drink("coke", 10));
Map<String, Integer> map = list.stream()
    .collect(Collectors.groupingBy(Drink::getName, 
                 Collectors.summingInt(Drink::getAmount)));
System.out.println(map);