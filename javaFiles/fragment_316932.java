private LSInput getLSInput(InputStream is) throws InstantiationException,
    IllegalAccessException, ClassNotFoundException {
    final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
    final DOMImplementationLS impl = (DOMImplementationLS)registry.getDOMImplementation("LS");

    LSInput domInput = impl.createLSInput();
    domInput.setByteStream(is);

    return domInput;
}