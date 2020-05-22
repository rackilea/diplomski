final ListChoice<String> hotelList = new ListChoice<String>("hotel", new PropertyModel<String>(this, "selectedHotel"), hotelLabels);
hotelList.add(new AjaxFormComponentUpdatingBehavior("onchange") {
  protected void onUpdate(AjaxRequestTarget target) {
    System.out.print(hotelList.getModel().getObject());
  }
});
hotelList.setOutputMarkupId(true);