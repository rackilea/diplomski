class CustomDeserializer implements JsonDeserializer<List<MyList>> {

    @Override
    public List<MyList> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

       JsonArray jsonArray =    jsonElement.getAsJsonObject().getAsJsonArray("list");

       List<MyList>  list=new ArrayList<>(30);
       Gson gson = new Gson();

       for (JsonElement element : jsonArray) {

                MyList ob =  gson.fromJson(element,  MyList.class);
                switch (Integer.valueOf(ob.type)) {
                case 0:
                    ob.arr = new boolean[5];
                    break;
                case 1:
                    ob.arr = new boolean[10];
                    break;
                }

               list.add(ob);
        }

        return list;
    }