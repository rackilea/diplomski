protected void onUpdate(AjaxRequestTarget target) {
    // here, ddcCountry's ModelObject has been already updated.
    List cities = myService.getCities(getComponent().getModelObject());
    ddcCity.setChoices(cities);
    ddcCity.setModelObject(null); // clear selection 
    if (target != null) { 
        target.addComponent(ddcCity);
    }
}