List <Country> countryList = httpSession.getAttribute("countryList");
if (countryList == null || countryList.isEmpty() {
    countryList = firmService.getEuCountries(cookie, requestEntity);
    httpSession.setAttribute("countryList", countryList);
}
model.put("countryList", countryList);