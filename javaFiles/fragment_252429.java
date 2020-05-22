private static String print1() {
        JSONObject body = new JSONObject();

        JSONObject eventLog1 = new JSONObject();
        JSONArray events1 = new JSONArray();
        events1.add(100L);
        events1.add(200L);
        eventLog1.put("storeId", "TMSUS");
        eventLog1.put("eventIds", events1);

        JSONObject eventLog2 = new JSONObject();
        JSONArray events2 = new JSONArray();
        events2.add(300L);
        events2.add(400L);
        eventLog2.put("storeId", "CBKUS");
        eventLog2.put("eventIds", events2);

        JSONArray eventLogs = new JSONArray();
        eventLogs.add(eventLog1);
        eventLogs.add(eventLog2);

        body.put("eventLogs", eventLogs);
        body.put("userName", "customer-portal-user");

        return body.toString();
    }