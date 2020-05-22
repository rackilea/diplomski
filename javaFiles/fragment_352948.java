static <T extends Element & Splittable<T>> void maybeAppend(T el1, Element el2) {
    if (el1.getClass() == el2.getClass()) {
        @SuppressWarnings("unchecked") // arguments' runtime types are equal
        final T el2WithNarrowedType = (T)el2;
        el1.append(el2WithNarrowedType);
    }
}

...

if (el instanceof Splittable<?>) {
    maybeAppend(el, nextEl); //compiler error
}