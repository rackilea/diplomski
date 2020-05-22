Stream<String> stringStream = Stream.of("unfiltered", "withDigit123", " white space ");

List<String> filtered = stringStream.map(s -> s.toUpperCase())//Can be replaced with .map(String::toUpperCase) if you want, but did it this way to make it easier to understand for someone new to all this.
        .map(s -> s.replaceAll("[0-9]", ""))//Removes all digits
        .map(s -> s.replace(" ", ""))//Removes all whitespace
        .collect(Collectors.toList());//Returns the stream as a list you can use later, technically not what you asked for so you can change or remove this depending on what you want the output to be returned as.

//Assertions, optional.
assertTrue(filtered.contains("UNFILTERED"));
assertTrue(filtered.contains("WITHDIGIT"));
assertTrue(filtered.contains("WHITESPACE"));