class MyObj {
        String title;
        String album;
        double length;
        String artist;
    }

    String json = "[\n" +
            "    {\n" +
            "        \"title\": \"Down\",\n" +
            "        \"album\": \"Down\",\n" +
            "        \"length\": 212.61,\n" +
            "        \"artist\": \"Jay Sean\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"title\": \"Come to Me (Peace)\",\n" +
            "        \"album\": \"Growing Pains\",\n" +
            "        \"length\": 301.844,\n" +
            "        \"artist\": \"Mary J Blige\"\n" +
            "    }\n" +
            "]";
    Type listType = new TypeToken<List<MyObj>>() {}.getType();
    List<MyObj> list = new Gson().fromJson(json, listType);
    System.out.println(new Gson().toJson(list));