public ListAdaptor(JList list, JTextComponent textComponent) {
    this(list, textComponent, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
}

public ListAdaptor(JList list, JTextComponent textComponent, ObjectToStringConverter stringConverter) {
    this.list = list;
    this.textComponent = textComponent;
    this.stringConverter = stringConverter;
    // when a new item is selected set and mark the text
    list.addListSelectionListener(this);
}