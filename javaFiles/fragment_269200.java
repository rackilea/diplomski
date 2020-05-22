ddcCity.setOutputMarkupId(true);
ddcCountry.add(new AjaxFormComponentUpdatingBehavior(){
    @Override
    protected void onUpdate(AjaxRequestTarget target) {
        // here, ddcCountry's ModelObject has been already updated.
        ddcCity.setModelObject(null); // clear selection 
        if (target != null) { 
            // Adding the ddc to the AjaxRequestTarget will write
            // it back to the ajax response with new options pulled 
            // from the choices model.
            target.addComponent(ddcCity);
        }
    }
}