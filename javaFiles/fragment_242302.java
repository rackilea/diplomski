JSONObject data = (JSONObject) jsonObject.get("data");
Iterator<?> keys = data.keySet().iterator();

    while (keys.hasNext()) {
            if (data.get(keys.next()) instanceof JSONObject) {
                JSONObject id = (JSONObject) data.get(keys.next());

                list.add((String) id.get("name"));
                System.out.println("Yo => " + (String) id.get("name"));
            }

        }