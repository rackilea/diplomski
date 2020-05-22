String words = "ASK NOT WHAT YOUR COUNTRY CAN DO FOR YOU ASK WHAT YOU CAN DO FOR YOUR COUNTRY";
// create a dictionary
Map<String, Integer> lookup = new LinkedHashMap<>();
// go through each word
String code = Stream.of(words.split(" "))
         // lookup the code for that word, or add one as needed
        .map(w -> lookup.computeIfAbsent(w, k -> lookup.size() + 1))
         // turn the codes into Strings
        .map(Object::toString)
         // join them together as one String.
        .collect(Collectors.joining(""));
System.out.println(code);
// dump the dictionary.
lookup.forEach((w, c) -> System.out.println(c + "=" + w));