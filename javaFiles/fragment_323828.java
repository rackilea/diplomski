<T> Container<T> makeContainer(String arg) {
    return new Container<T>(arg);
}

...

Container<?> c = makeContainer(arg);