public class Item {
    long item_id;
    int state;
    @SerializedName("time_added")
    Date timeAdded;
    @SerializedName("time_updated")
    Date timeUpdated;
    String title;
    String url;

    // getter & setters
}

public class Trade {
    int complete;
    Date since;
    int status;
    Map<Long, Item> list;

    // getter & setters
}

public class Foo {
    public static void main(String[] args) {
        String json = "";

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong()); 
            } 
        });
        Gson gson = builder.create();
        Trade trade = gson.fromJson(json, Trade.class);
        Map<Long, Item> items = trade.getList();
        System.out.println(items.get(217345740L).getUrl()); // should print http://t.co/dCvNwtrK
    }
}