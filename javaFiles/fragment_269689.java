comboBox.addListener(new Property.ValueChangeListener() {
    public void valueChange(ValueChangeEvent event) {
        String customQuery = query.replace(":clientId", ((Client)(event.getProperty()).getId(), pks);
        table.setContainerDataSource(new SQLContainer(new FreeformQuery(customQuery, pool)));
    }
});