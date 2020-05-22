interface HasType {
    String getType();
}
enum PetType implements HasType {
    ...
}
private <E extends Enum<E> & HasType> List<OptionDTO>(E[] values) {
    ...
}