class MyTypeModelDeserializer implements JsonDeserializer<MyBaseTypeModel> {

    @Override
    public MyBaseTypeModel deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        JsonElement jsonType = jsonObject.get("type");
        String type = jsonType.getAsString();

        MyBaseTypeModel typeModel = null;     

        if("type1".equals(type)) {
            typeModel = new Type1Model();
        } else if("type2".equals(type)) {
            typeModel = new Type2Model();
        }
        // TODO : set properties of type model

        return typeModel;
    }
}