public void onModuleLoad() {
    final ListDataProvider<String> provider = new ListDataProvider<String>(getList());
    CellList<String> list = new CellList<String>(new TextCell());
    provider.addDataDisplay(list);

    Button btn = new Button("add more");
    btn.addClickHandler(new ClickHandler() {

        private int counter = 0;

        @Override
        public void onClick(ClickEvent event) {
            provider.getList().add(++counter + " more");
        }
    });

    RootPanel.get().add(list);
    RootPanel.get().add(btn);
}

private LinkedList<String> getList() {
    LinkedList<String> list = new LinkedList<String>();
    list.add("1st");
    list.add("2nd");
    list.add("3rd");
    list.add("4th");
    list.add("5th");
    return list;
}