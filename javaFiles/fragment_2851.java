List<MyObject> filtered = objects.stream()
            .filter(o -> o.getMyString().equals("myString"))
            .collect(Collectors.toList());

Collections.shuffle(filtered);
List randomList = filtered.subList(0, n);
objects.removeAll(randomList);