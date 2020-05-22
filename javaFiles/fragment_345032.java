final boolean a = true, b = true, c = true;
final String[] values = new String[] {a ? "a" : null, b ? "b" : null, c ? "c" : null};
final String result = Arrays.asList(values).stream()
        .filter(o -> o != null) // discard all null (false) values in the list
        .collect(Collectors.joining(", ")) // join all elements by concatenating with ','
        .replaceAll(", (a|b|c)$", " and $1"); // replace last ',' with 'and'