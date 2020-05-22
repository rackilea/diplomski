import java.util.HashMap;
    import java.util.Map;

    public class PartialAddressSearch {

        private final static Map<String, AddressPartHolder> COUNTRY_MAP = new HashMap<>(200);

        private static class AddressPartHolder {
            int id;
            Map<String, AddressPartHolder> subPartMap;

            public AddressPartHolder(int id, Map<String, AddressPartHolder> subPartMap) {
                this.id = id;
                this.subPartMap = subPartMap;
            }
        }

        public static int getCountryStateCityHashCode(String country, String state, String city) {
            if (country != null && country.length() != 0) {
                int result = 0;
                AddressPartHolder countryHolder = COUNTRY_MAP.get(country);
                if (countryHolder == null) {
                    countryHolder = new AddressPartHolder(COUNTRY_MAP.size() + 1, new HashMap<>());
                    COUNTRY_MAP.put(country, countryHolder);
                }
                result += countryHolder.id * 10000000;

                if (state != null) {
                    AddressPartHolder stateHolder = countryHolder.subPartMap.get(state);
                    if (stateHolder == null) {
                        stateHolder = new AddressPartHolder(countryHolder.subPartMap.size() + 1, new HashMap<>());
                        countryHolder.subPartMap.put(state, stateHolder);
                    }
                    result += stateHolder.id * 10000;

                    if (city != null && city.length() != 0) {
                        AddressPartHolder cityHolder = stateHolder.subPartMap.get(city);
                        if (cityHolder == null) {
                            cityHolder = new AddressPartHolder(stateHolder.subPartMap.size() + 1, null);
                            stateHolder.subPartMap.put(city, cityHolder);
                        }
                        result += cityHolder.id;
                    }
                }

                return result;
            } else {
                throw new IllegalArgumentException("Non-empty country is expected");
            }
    }