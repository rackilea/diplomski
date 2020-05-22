public String searchForCapital(String countryName) {

    for (Country c : elementsList) {
        if (c.getCountry().equalsIgnoreCase(countryName)) {
            return c.getCapital();
        }
    }
    return null;
}