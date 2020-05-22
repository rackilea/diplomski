Value value1 = new Value("label1", 1);
        Value value2 = new Value("label2", 2);
        Map<String, Value> data = new HashMap<>();
        data.put("age", value1);
        data.put("email", value2);
        Filters filters = new Filters(data);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Log.d("json", gson.toJson(new Holder(filters)));