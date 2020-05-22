public static Result getByArgOfAnyType(String arg) {
    try {
        Long.parseLong(arg);
        return ok("Long: " + arg);
    } catch (Exception e) {
        return ok("String: " + arg);
    }
}