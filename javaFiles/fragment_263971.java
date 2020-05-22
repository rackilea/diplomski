// Note the use of a String array, not a single String

public static void runCode(String... javaArgs) {

    List<String> args = new ArrayList<>();
    args.add("java");
    Collections.addAll(args, javaArgs);

    ProcessBuilder processBuilder = new ProcessBuilder(args);