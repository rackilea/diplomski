public class CountryResource extends ServerResource {
    CountryManager cm;
    TemplateManager tm;

    public CountryTemplate() throws Exception {
        // Note: I usually do NOT define a constructor using Restlets,
        // but you should be OK doing this
        cm = new CountryManager();
        tm = new TemplateManager();
    }

    @Get("html")
    public String getTemplate() throws IOException, RemoteException, UnsupportedCurrencyException {
        String countryID = getQueryValue("countryID");
        Country country = tm.getCountry(countryID);

        return tm.GetTemplate(country);
    }
}