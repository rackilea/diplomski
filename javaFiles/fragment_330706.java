class ElementKindPredicate<T extends Element> implements Predicate<T> {
    private final ElementKind kind;
    public ElementKindPredicate(ElementKind kind) {
      Preconditions.checkArgument(kind != null);
      this.kind = kind;
    }
    @Override
    public boolean apply(T input) {
      return input.getKind().equals(kind);
    }
}

private static final ElementKindPredicate ENUM_VALUE_PREDICATE = new ElementKindPredicate(ElementKind.ENUM_CONSTANT);

public static List<String> getEnumValues(TypeElement enumTypeElement) {
    Preconditions.checkArgument(enumTypeElement.getKind() == ElementKind.ENUM);
    return FluentIterable.from(enumTypeElement.getEnclosedElements())
        .filter(ENUM_VALUE_PREDICATE)
        .transform(Functions.toStringFunction())
        .toList();
}