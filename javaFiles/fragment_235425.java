public static List<String> fixArguments(List<String> args) {
    List<String> fixed = new ArrayList<>();
    StringBuilder building = new StringBuilder();
    boolean build = false;
    for (String arg : args) {
        // A " at the start switches to building.
        if (arg.charAt(0) == '\"') {
            build = true;
            building.setLength(0);
        }
        if (build) {
            if (building.length() > 0) {
                building.append(" ");
            }
            building.append(arg);
        } else {
            fixed.add(arg);
        }
        // A " at the end stops the building.
        if (arg.charAt(arg.length() - 1) == '\"') {
            fixed.add(building.toString());
            build = false;
        }
    }
    return fixed;
}

public static String[] fixArguments(String[] arguments) {
    // Roll the array into a List
    List<String> args = Arrays.asList(arguments);
    List<String> fixed = fixArguments(args);
    String[] results = new String[fixed.size()];
    // Roll out the results back into an array.
    for (int i = 0; i < results.length; i++) {
        results[i] = fixed.get(i);
    }
    return results;
}

public void test() {
    String[] arguments = new String[]{"One", "\"Two,", "Three,", "Four\"", "Five"};
    String[] fixed = fixArguments(arguments);
    System.out.println("Before: " + Arrays.asList(arguments));
    System.out.println("After : " + Arrays.asList(fixed));
}