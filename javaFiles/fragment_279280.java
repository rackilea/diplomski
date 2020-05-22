mainCatTable.addValueChangeListener(new ValueChangeListener() {

    @Override
    public void valueChange(ValueChangeEvent event) {

        Property<Table> p = event.getProperty(); //property of valuechangeevent in this case the Table instance
        Object itemId = p.getValue(); //selected item in table. also known as "itemId"

        Property<?> containerPropertyName = mainCatTable.getContainerProperty(itemId, "HAUPTKATEGORIE");
        System.out.println("HAUPTKATEGORIE : " + containerPropertyName.getValue());

    }
});