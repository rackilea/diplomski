public enum Continent { None, Europe, Africa, NorthAmerica, SouthAmerica, Asia }

public class CountrySpecification {

    public DateRange CreatedInRange { get; set; }
    public Continent Location { get; set; }
}

public class CountryService {

    public IEnumerable<Country> Find(CountrySpecification spec) {

        var url = "https://api.myapp.com/countries";
        url = AddQueryParametersFromSpec(url, spec);
        var results = SendGetRequest(url);
        return CreateCountryFromApiResults(results);
    }
}