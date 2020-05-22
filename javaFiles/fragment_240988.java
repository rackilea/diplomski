public void describe(String desc) {
    if (desc == null || desc.trim().isEmpty())
        throw new IllegalArgumentException("[desc] parameter is null or empty");

    ...
}