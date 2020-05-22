DataView<Entry<String, String>> dataView = new DataView<~>("displayPanel", new ListDataProvider(new ArrayList<Entry<String, String>(map.entrySet())) {
    @Override
    protected void populateItem(Item item) {
        Entry<String, String> entry = item.getModelObject();
        item.add(new Label("key_column", entry.getKey()));
        item.add(new Label("value_column", entry.getValue()));
    }
});