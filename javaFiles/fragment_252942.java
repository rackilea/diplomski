JsonDeserializer<LocalTime> localTimeDeserializer = new JsonDeserializer<LocalTime>() {

            @Override
            public LocalTime deserialize(JsonElement jsonElem, Type type,
                    JsonDeserializationContext context) throws JsonParseException {

                if (jsonElem == null) {
                    return null;
                }

                String localTimeStr = jsonElem.getAsString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime localTime = LocalTime.parse(localTimeStr, formatter);
                return localTime;
            }
        };

        Gson gson = new GsonBuilder()
                          .registerTypeAdapter(LocalTime.class, localTimeDeserializer).create();

        Type listType = new TypeToken<Program>() {}.getType();
        Program program = gson.fromJson(json, listType);