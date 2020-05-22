@InitBinder
public void initBinder(WebDataBinder binder) {
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, dateEditor);

    binder.registerCustomEditor(CampaignCities.class, "cities", new PropertyEditorSupport() {
        @Override
        public void setAsText(String text) {
            String [] ids = text.split(",");
            CampaignCities cities = null;
            for(String id:ids){
                if(cities == null)
                    cities = new CampaignCities();
                City city = cityManager.getCity(new Long(id));
                if(city != null)
                    cities.getCities().add(city);

            }
            if(cities != null){
                cities.setId(null);
                setValue(cities);
            }
        }
    });