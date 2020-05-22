class Country {
    public String countryId;
    public String countryName;
}
...
Country[] countryArray = gson.fromJson(myJsonString, Country[].class);