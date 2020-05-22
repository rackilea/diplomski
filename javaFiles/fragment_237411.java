import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

    Client client = Client.create();
    WebResource webResource2 = client.resource("https://data.montgomerycountymd.gov/api/views/54rh-89p8/rows.json?accessType=DOWNLOAD");
    ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
    if (response2.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
    }

    String output2 = response2.getEntity(String.class);
    JsonParser parser = new JsonParser();
    JsonElement parsed = parser.parse(output2);
    JsonObject asJsonObject = parsed.getAsJsonObject();
    JsonArray data = asJsonObject.getAsJsonArray("data");
    for(int i=0; i<data.size(); i++) {
        JsonElement jsonElement = data.get(i);
        JsonArray subdata = jsonElement.getAsJsonArray();
        for(int j=0; j<subdata.size(); j++) {
            JsonElement subelement = subdata.get(j);
            if(subelement.isJsonNull()) {
                break;
            }
            System.out.print(subelement.getAsString() + ",");
        }
        System.out.println();
    }