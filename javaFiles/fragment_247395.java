@Data
public class Provider {
    private Long id;
    private String name;
    private String url;
    private boolean active;
}

@Data
public class ProviderList {
    List<Provider> providerList;
}

public class JsonTest {

    @Test
    public void  test() {
        String json = "[{\n" +
                "        \"id\": \"1\",\n" +
                "        \"name\": \"some name\",\n" +
                "        \"url\": \"some url\",\n" +
                "        \"active\": true\n" +
                "    }, {\n" +
                "        \"id\": \"2\",\n" +
                "        \"name\": \"some other name\",\n" +
                "        \"url\": \"some other url\",\n" +
                "        \"active\": true\n" +
                "    }\n" +
                "]";

        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Provider> providerList = mapper.readValue(json, new TypeReference<List<Provider>>(){});
            for (Provider provider : providerList) {
                System.out.println(provider);
            }

            ProviderList list = new ProviderList();
            list.setProviderList(providerList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}