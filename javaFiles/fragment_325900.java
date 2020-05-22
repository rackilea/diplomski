JSONObject coordsPack = (JSONObject) outputJSON.get("coords");
        JSONObject merged = new JSONObject();
        JSONArray xList = new JSONArray();
        JSONArray yList = new JSONArray();
        for (String index : tokens) {
            JSONObject coordXY = (JSONObject) coordsPack.get(index);
            xList.addAll((JSONArray) coordXY.get("x"));
            yList.addAll((JSONArray) coordXY.get("y"));
        }
        merged.put("x", xList);
        merged.put("y", yList);
        System.out.println(merged);