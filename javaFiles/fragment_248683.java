private <T extends Enum<T>> String getEnumValues(Enum<? extends T>[] e) {
    StringBuilder sb = new StringBuilder();
    String sep = "";
    for (Enum<? extends T> v : e) {
        sb.append(sep);
        sb.append(v.name());
        sep = "|";
    }
    return sb.toString();
}