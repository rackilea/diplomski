String[] words = {"bad", "bat","hat"};
String filter = "at";

List<String> list = Stream.of(words)
        .filter(word -> word.contains(filter))
        .collect(Collectors.toList());

System.out.println(list);