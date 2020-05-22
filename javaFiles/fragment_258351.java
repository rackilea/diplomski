public static JSONObject toJsonObject(Object classObject) {
        // get Method names with @JsonElement included

        Method methods[] = classObject.getClass().getDeclaredMethods();

        JSONObject jsonObject = new JSONObject();
        try {
            for (int i = 0; i < methods.length; i++) {
                String key = methods[i].getName();
                System.out.println(key);
                if (methods[i].isAnnotationPresent(JsonElement.class) && key.startsWith(GET_CHAR_SEQUENCE)) {
                    key = key.replaceFirst(GET_CHAR_SEQUENCE, "");
                    jsonObject.put(key, methods[i].invoke(classObject));
                }

            }
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }