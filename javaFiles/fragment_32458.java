public static void main(String[] args) {
    Map<String, String> argsMap = new LinkedHashMap<>();
    for (String arg: args) {
        String[] parts = arg.split("=");
        argsMap.put(parts[0], parts[1]);
    }

    argsMap.entrySet().forEach(arg-> {
        System.out.println(arg.getKey().replace("--", "") + "=" + arg.getValue());
    });
}