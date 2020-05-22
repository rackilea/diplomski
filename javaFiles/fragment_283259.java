public class JacksonXml {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        InputStream is = JacksonXml.class.getResourceAsStream("/countries.xml");

        XmlMapper xmlMapper = new XmlMapper();

        List<Country> countries = xmlMapper.readValue(is, new TypeReference<List<Country>>() {
        });

        Map<String, Country> nameToCountry = countries.stream()
                                                      .collect(Collectors.toMap(Country::getName, Function.identity()));

        System.out.println(nameToCountry.get("England")
                                        .getRegion());
    }

}