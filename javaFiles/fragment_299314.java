@SuppressWarnings("unchecked")
public static <S> void useEntries() {
    for(Entry<GenericObject<?>, Function<?, ?>> currentEntry : map.entrySet()) {
        GenericObject<S> key = (GenericObject<S>)currentEntry.getKey();
        Function<S, S> value = (Function<S, S>)currentEntry.getValue();
        key.set(value.apply(key.get()));
    }
}