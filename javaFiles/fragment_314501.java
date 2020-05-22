private void parseJson(JSONObject data) {

        if (data != null) {
            Iterator<String> it = data.keys();
            while (it.hasNext()) {
                String key = it.next();

                try {
                    if (data.get(key) instanceof JSONArray) {
                        JSONArray arry = data.getJSONArray(key);
                        int size = arry.length();
                        for (int i = 0; i < size; i++) {
                            parseJson(arry.getJSONObject(i));
                        }
                    } else if (data.get(key) instanceof JSONObject) {
                        parseJson(data.getJSONObject(key));
                    } else {
                        System.out.println("" + key + " : " + data.optString(key));
                    }
                } catch (Throwable e) {
                    System.out.println("" + key + " : " + data.optString(key));
                    e.printStackTrace();

                }
            }
        }
    }