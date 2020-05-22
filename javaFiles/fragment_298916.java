String payload = "{\"key\" : {\"key1\" : \"value1\",\"key2\" : \"value2\"}, \"key3\": \"value\"}";
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(UpperCaseAdapter.TYPE, new UpperCaseAdapter())
                .create();
        Map<String, Object> mapDeserialized = gson.fromJson(payload, UpperCaseAdapter.TYPE);

        System.out.println("Map " + mapDeserialized);