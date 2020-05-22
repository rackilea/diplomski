Iterator<String> keys = idObj.keys();

while (keys.hasNext()) {
      String key = keys.next();
      if (idObj.get(key) instanceof JSONObject) {

            Iterator<String> idObjkeys = idObj.getJSONObject(key).keys();

            while (idObjkeys.hasNext()) {
                 String subkey = idObjkeys.next();

            }
      }

      if (idObj.getJSONObject(key).get(subkey) instanceof String) {}

    }