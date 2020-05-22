interface ElementSplitter<T extends Element> {

    T splitOff(T element, double at);

    void append(T element, T appendedElement);
}