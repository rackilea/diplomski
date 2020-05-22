private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(ScriptElement.class, (JsonDeserializer<ScriptElement>) (jsonElement, type, context) -> {
            final String actionType = jsonElement.getAsJsonObject().getAsJsonPrimitive("actionType").getAsString();
            switch ( actionType ) {
            case "click":
                return context.deserialize(jsonElement, ScriptClickable.class);
            case "write":
                return context.deserialize(jsonElement, ScriptInput.class);
            default:
                throw new JsonParseException("Unrecognized action type: " + actionType);
            }
        })
        .create();