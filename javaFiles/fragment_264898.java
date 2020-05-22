//assume your Day enum has more values
String string = "[Monday, Wednesday, Tuesday, Friday, Thursday]";
String stringWithNoBrackets = string.substring(1, string.length() - 1);
List<Days> days = Arrays.asList(stringWithNoBrackets.split(",\\s+"))
        .stream()
        .map(Days::valueOf)
        .collect(Collectors.toList());
System.out.println(days);