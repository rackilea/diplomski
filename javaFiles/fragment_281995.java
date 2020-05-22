public static Result getByLong(Long id) {
    return ok("Long value: " + id);
}

public static Result getByString(String name) {
    return ok("String value: " + name);
}