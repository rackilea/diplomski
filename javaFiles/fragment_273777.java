@AutoValue
public abstract class SimpleClass<T> {
    public static <E> SimpleClass<E> create(Set<? extends E> someField) {
        return SimpleClass.<E>getBuilder().someField(someField).build();
    }

    public static <E> Builder<E> getBuilder() {
        return new AutoValue_SimpleClass.Builder<E>();
    }

    public abstract ImmutableSet<T> someField();

    @AutoValue.Builder
    public abstract static class Builder<T> {
        public abstract Builder<T> someField(Set<? extends T> someField);
        public abstract SimpleClass<T> build();
    }
}