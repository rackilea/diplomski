public MigTable(Element element, String string) {
    super(element,string);
    for (int index = 0; index < data.size(); index++) {
        setValueAt(data.get(index), index, 2);
    }
}