public static String getMethodName(String source, String fieldName) {
        if(source.startsWith("{") && source.endsWith("}")) {
            source = source.substring(1, source.length() - 1);
        }
        return Arrays.asList(source.split(",")).stream()
                .map(s -> s.trim().split("="))
                .filter(s -> fieldName.equals(s[0]))
                .map(s -> s[1])
                .findFirst()
                .orElse(null);
}