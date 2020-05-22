ListView<String> textAreasListView = new ListView<String>("someid", bean.map.keySet()) {
    @Override
    protected void populateItem(final ListItem<String> itemLang) {
        itemLang.add(new Label("label", itemLang.getModelObject()));
        Model<String> textModel = new Model<String>() {

            @Override
            public String getObject() {
                return bean.map.get(itemLang.getModelObject()).toString;
            }

            @Override
            public void setObject(String object) {
                bean.map.put(itemLang.getModelObject(), new Address(object));
            }
        };
        itemLang.add(new TextField<String>("email", textModel));
    }
};