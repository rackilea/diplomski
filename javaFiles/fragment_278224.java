private JAXBElement clone(JAXBElement o) {
    JAXBElement clone = new JAXBElement();

    clone.setName(o.getName());
    ...

    return clone;
}