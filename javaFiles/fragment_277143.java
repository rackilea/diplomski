class MyCreator<T> implements JsonDeserializer<T>
{

    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException
    {
        try
        {
            Gson g = new Gson();
            T a = g.fromJson(json, typeOfT);
            Class<? extends Object> class1 = a.getClass();
            Method getter = class1.getMethod("getSymbol", null);
            Method setter = class1.getMethod("setTest", String.class);
            String symbol = (String) getter.invoke(a, null);
            setter.invoke(a, symbol);
            return a;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}