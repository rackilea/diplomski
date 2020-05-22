public static Map<String, Object> convertJsonToMap(String json) {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject jsonObject = null;

        try {
            if (null != json) {
                jsonObject = new JSONObject(json);
                map = getMap(jsonObject, json);
            }

        } catch (Exception e) {
            throw new SystemException("Unable to read JSOn Object");
            // TODO : Handle Exception
        }
        return map;
    }