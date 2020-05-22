public static Set<String> stringSubsets(String str) {
    if (str.isEmpty()) {
        return new TreeSet<>(Arrays.asList(""));
    } else {
        char currentChar = str.charAt(0);
        String rest = str.substring(1);

        Set<String> combinationsOfRest = stringSubsets(rest);
        Set<String> result = new TreeSet<>();

        result.addAll(combinationsOfRest);
        for (String c: combinationsOfRest)
            result.add(currentChar + c);

        return result;
    }
}