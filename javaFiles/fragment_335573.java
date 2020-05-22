public <H> Optional<T> with(BiConsumer<T, H> setter, H value)
{
    requireNonNull(setter);

    if (!isPresent())
        return empty();

    setter.accept(this.value, value);

    return this;
}