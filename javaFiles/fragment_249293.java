@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int countriesListID;
private String countriesList;

public String getCountriesList() {
    return countriesList;
}

public void setCountriesList(String countriesList) {
    this.countriesList = countriesList;
}

public int getCountriesListID() {
    return countriesListID;
}

public void setCountriesListID(int countriesListID) {
    this.countriesListID = countriesListID;
}
public String toString(){
    return countriesList;
}