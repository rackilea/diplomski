String sampleData = //
        "[" //
                + "{\"info\": {\"place\": \"place1\"},"
                + "\"events\": {\"info\": \"555f1fc297f229004dd6e8aa\",\"time\": \"5\",\"image\": \"555f1fc2d197270b6c732d3b\",\"event_name\": \"555f1fc224d1cb629a8ef603\"}},"
                + "{\"info\": {\"place\": \"place3\"},"
                + "\"events\": {\"info\": \"555f1fc283c7b150ede89c05\",\"time\": \"7\",\"image\": \"555f1fc2bf5fa8a3b320e0ca\",\"event_name\": \"555f1fc20d40f1b478610505\"}},"
                + "{\"info\": {\"place\": \"place2\"},"
                + "\"events\": {\"info\": \"555f1fc29163e85ae42e7518\",\"time\": \"6\",\"image\": \"555f1fc21506a186c2d34a92\",\"event_name\": \"555f1fc272a06e68b8c3f4b7\"}}" + "  ]";

    java.lang.reflect.Type listType = new TypeToken<List<Event>>() {
    }.getType();
    ArrayList<Event> eventList = gson.fromJson(sampleData, listType);