private DropDownChoice ddcCountry;
private DropDownChoice ddcCity;
//...

IModel countriesModel = new LoadableDetachableModel(){
   @Override
   protected Object load() {
      return myService.getCountries();
   }
};
IModel citiesModel = new LoadableDetachableModel(){
   @Override
   protected Object load() {
      if (ddcCountry.getModelObject() != null){
          return myService.getCities(ddcCountry.getModelObject());
      }
      else { return new ArrayList(); }
   }
};
ddcCountry = new DropDownChoice("country", null, countriesModel);
ddcCity = new DropDownChoice("city", null, citiesModel);