public static Cases fromLabel(String label)
{
    return Stream.of(Cases.values())
    .filter(c -> c._case.equals(label))
    .findFirst().orElse(null);
}