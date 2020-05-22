List<StringBuilder> services = new ArrayList<>();
services.add (new StringBuilder());
services.add (new StringBuilder());
services.get (0).append ("one two three");
services.get (1).append ("four five six");
List<Supplier<List<String>>> list = 
services.stream()
        .map(s -> (Supplier<List<String>>) (() -> Arrays.asList(s.toString().split(" "))))
        .collect(Collectors.toList());
System.out.println (list.get (0).get ());
System.out.println (list.get (1).get ());