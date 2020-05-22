public class Country {
    // ...

    @OneToMany(mappedBy = "parentCountry");
    private Set<City> cities;
}

public class City {
    // ...

    @ManyToOne
    @JoinColomn(name = "country_id")
    private Country parentCountry;
}