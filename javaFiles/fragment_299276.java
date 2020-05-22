public SuggestingField extends CustomField<Model> {
    private Model model;
    ...
    public SuggestingField() {
        ...
        container = new SuggestingContainer<ObjectItem>(ObjectItem.class) {
            @Override
            protected void filterItems(String filterString) {               
                removeAllItems();

                if("".equals(filterString)) {
                    if(model != null) {
                        ObjectItem it = new ObjectItem();
                        it.setId(model.getId()+"");
                        it.setText(model.toString());
                        it.setObject(model);

                        addItem(it);
                        return;
                    }
                }

                List<Model> result; //Obtain here the results
                List<ObjectItem> lItems = result.stream()
                    .map(m -> new ObjectItem(m.getId()+"", m.toString(), m))
                    .collect(Collectors.toList());
                addAll(lItems);
            }
        };
        suggestingCB.addValueChangeListener(ev -> {
            this.model = (Model) suggestingCB.getValue();
        });