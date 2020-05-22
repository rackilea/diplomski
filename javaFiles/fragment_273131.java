private static void parseJSONLocations(JSONObject locations, Locations[] location, Objects[] object) {
        JSONObject locationObject = (JSONObject) locations.get("locations");
        String desc = (String) locationObject.get("description");
        String name = (String) locationObject.get("name");
        JSONArray objects = (JSONArray) locationObject.get("objects");

        Iterator<String> it = objects.iterator();
        List<Objects> objs = new ArrayList<>();
        while (it.hasNext()) {
            String mStr = it.next();
            for (Objects elm : object) {
                if (elm.getName().equals(mStr)) {
                    objs.add(elm);
                }
            }
        }

        JSONArray directions = (JSONArray) locationObject.get("directions");
        Map<String, String> map = new HashMap<>();
        Iterator<JSONObject> it2 = directions.iterator();
        while (it2.hasNext()) {
            JSONObject value = it2.next();
            map.put((String) value.get("direction"), (String) value.get("location"));
        }
        location[index2] = new Locations(desc, name, objs, map);
        index2++;
    }