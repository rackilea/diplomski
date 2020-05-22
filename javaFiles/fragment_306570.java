final String json = "{\"id\":81,\"nomes\":[{\"id\":124,\"nome\":\"aleluia\",\"etimologia\":\"asasiajisjaijs\"},{\"id\":126,\"nome\":\"amém\",\"etimologia\":\"asasiajisjaijs\"}],\"significados\":[{\"id\":67,\"significado\":\"asasjaijsiajsoijaoisjaoisj\",\"categoria\":{\"id\":3,\"nome\":\"Nada\",\"descricao\":\"asuahushaus\",\"serie\":1}}],\"totalAcessos\":0,\"dataLancamento\":1382066568000,\"relevancia\":0}";
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Date.class,
            new JsonDeserializer<Date>() {
                @Override
                public Date deserialize(JsonElement jsonElement, Type type,
                        JsonDeserializationContext context)
                        throws JsonParseException {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(jsonElement.getAsLong());
                    return calendar.getTime();
                }
            });
    Gson gson = gsonBuilder.create();
    Verbete verbete = gson.fromJson(json, Verbete.class);

    System.out.println(verbete);