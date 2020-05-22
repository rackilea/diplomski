@Override
public JsonPostalCodeList findPostalCodes(
        JsonPostalCodeSelectorData selectorData) {
    String url = getWebserviceLocation()+"/rest/postalcode/list/filter?lang={lang}&postalcode={postalcode}&country={country}&city={city}";
    MbaLog.debugLog(logger,"Calling webservice with url: " + url);
    return getRestTemplate().getForObject(url, JsonPostalCodeList.class, selectorData.getContactLanguage(), selectorData.getPostalCode(), selectorData.getCountry(), selectorData.getCity());       
}