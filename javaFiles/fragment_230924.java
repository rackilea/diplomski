JComboBox box=new JComboBox(getAllCountries());


 public String[] getAllCountries() {
    String[] countries = new String[Locale.getISOCountries().length];
    String[] countryCodes = Locale.getISOCountries();
    for (int i = 0; i < countryCodes.length; i++) {
        Locale obj = new Locale("", countryCodes[i]);
        countries[i] = obj.getDisplayCountry();
    }
    return countries;
 }