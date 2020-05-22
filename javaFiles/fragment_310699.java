private static HashMap<String, Object> getParams() {
        Random rand = new Random();
        String ids = "";
        for (int i = 0; i < MAX_REQUESTS; i++) {
            ids += "W" + Integer.toString(rand.nextInt(10000000) + 10000000) + ',';
        }

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("osmId", ids);
        params.put("format", "json");

        return params;
    }