private static boolean checkJsonPredicate(JsonElement element, JsonElement predicate) {
    if (predicate == null) {
        return true;
    }

    if (element == null || predicate.getClass() != element.getClass()) {
        return false;
    }

    if (predicate.isJsonObject()) {
        return predicate.getAsJsonObject().entrySet().stream()
                .allMatch(e -> checkJsonPredicate(element.getAsJsonObject().get(e.getKey()), e.getValue()));
    }

    if (predicate.isJsonArray()) {
        return StreamSupport.stream(predicate.getAsJsonArray().spliterator(), false)
                .allMatch(element.getAsJsonArray()::contains);
    }

    return predicate.equals(element);
}