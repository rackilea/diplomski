QCountryLayerCount countryLayerCountSurrogate = 
QCountryLayerCount.countryLayerCount;
    CountryLayerCount levelDepthQuery = currentSession
            .query(CountryLayerCount.class, "CountryLayerCount/ByName")
            .where(countryLayerCountSurrogate.countryName.eq(countryName))
            .single();