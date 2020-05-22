public FoodFieldPanel(String id, IModel<AllData> model) {
  super(id);
  WebMarkupContainer foodFields = new WebMarkupContainer("foodFields", new CompoundPropertyModel( model.getObject().createDataModel() ) );
  TextField monday = new TextField("monday");
  TextField tuesday = new TextField("tuesday");
  //...
  foodFields.add(monday);
  foodFields.add(tuesday);
  //
  add(foodFields);
}