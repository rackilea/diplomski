Locale convertCountryNameToIsoCode(String countryName)
    for(Locale l : Locale.getAvailableLocales()) {
        if (l.getDisplayCountry().equals(countryName)) {
            return l;
        }
    }
    return null;
}