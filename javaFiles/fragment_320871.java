static Integer parseIntOrNull(String s) {
    try {
        return Integer.parseInt(s);
    } catch (NumberFormatException nfe) {
        System.err.println(nfe.getMessage());
    }
    return null;
}

intList = strList.stream()
            .map(x -> parseIntOrNull(x))
            .filter(x -> x!= null)
            .collect(Collectors.toList());