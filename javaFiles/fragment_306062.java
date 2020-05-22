public static void main(final String... args)
        throws IOException {
    System.out.println(isJsonValid("\"abc\""));
    System.out.println(isJsonValid("{\"name\": \"mike\"}"));
    System.out.println(isJsonValid("abc"));
    System.out.println(isJsonValid("{\"name\": mike}"));
    System.out.println(isJsonValid("{name: mike}"));
    System.out.println(isJsonValid("{name: \"mike\"}"));
}