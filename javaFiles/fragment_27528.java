List<Country> countryList = ...;
List<CountryDTO> countryDtoList = countryList.stream()
                                             .map(MyClass::countryToDTO)
                                             .collect(toList());

private static CountryDTO countryToDTO(Country country) {
  CountryDTO countryDto=new CountryDTO();
  countryDto.setCountryId(country.getCountryId());
  countryDto.setCountryName(country.getCountryName());
  countryDto.setCapital(country.getCapital());
  List<CityDTO> cityDtoList = cityRepository.getCitiesForCountry(country.getCountryId())
                                            .stream()
                                            .map(MyClass:cityToDTO)
                                            .collect(toList());
  countryDto.setCities(cityDtoList);
  return countryDTO;
}

private static CityDTO cityToDTO(City city) {
  CityDTO cityDto=new CityDTO();
  cityDto.setCityId(city.getCityId());
  cityDto.setCityName(city.getCityName());
  return cityDTO;
}