public <T> List<T> listEntity(Class<T> clazz)
        throws WsIntegracaoException {
    try {
        // Consuming remote method
        String strJson = getService().listEntity(clazz.getName());

        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(strJson).getAsJsonArray();

        List<T> lst =  new ArrayList<T>();
        for(final JsonElement json: array){
            T entity = GSON.fromJson(json, clazz);
            lst.add(entity);
        }

        return lst;

    } catch (Exception e) {
        throw new WsIntegracaoException(
                "WS method error [listEntity()]", e);
    }
}