@Override
 protected void populateItem(ListItem<ListViewModel> item) {     
     item.add(new TextField<Integer>("quantity", new PropertyModel<Integer>(item.getDefaultModelObject(),
     "averageQuantity"));
     item.add(new TextField<Integer>("position", new PropertyModel<Integer>(item.getDefaultModelObject(), "order"))
     .add(new IntegerValidator()));
     item.add(new Label("description", item.getModelObject().getName()));
     item.setOutputMarkupId(true);
 }