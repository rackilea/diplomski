interface SerializableCallable<T> extends Serializable, Callable<T> {}

...

static Comparator<String> COMPARE_STRING_LENGTH = 
    new SerializableCallable<Comparator<String>>() {
       ...
};