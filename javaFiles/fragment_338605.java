public class Test {  
      public static void main(String[] args) {
            ClientConfig config = new DefaultClientConfig();
            Client client = Client.create(config);
            WebResource service = client.resource(getBaseURI());

            // Now do the MAP stuff
            MyHashMapObject<String, String> map = new MyHashMapObject<String, String>();
            map.getMapProperty().put("a", "1");
            map.getMapProperty().put("b", "2");

            ClientResponse response = service.path("rest").path("hello2")
                .type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .post(ClientResponse.class, map);

            Map<String, String> myMap = response.getEntity(MyHashMapObject.class).getMapProperty();     
            for(Map.Entry<String, String> entry : myMap.entrySet())
                System.out.format("Key: %s, Value: %s\n", entry.getKey(), entry.getValue());

        }

        private static URI getBaseURI() {
            return UriBuilder.fromUri(
                    "http://localhost:8080/org.nowaq.jersey.first").build();
        }
    }