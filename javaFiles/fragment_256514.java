int index = N - 2;
MyType defaultValue = null;

StreamSupport.stream(iterable.spliterator(), false)
    .skip(index)
    .findFirst()
    .orElse(defaultValue);