public class GsonTest
{
    public static void main(String[] args)
    {
        // Note the time zone format tweak (removed the ':')
        String json = "[{\"2011-04-30T00:00:00-0700\":100}, {\"2011-04-29T00:00:00-0700\":200}]";

        Gson gson =
            new GsonBuilder()
            .registerTypeAdapter(MyCustomClass.class, new MyCustomDeserializer())
            .create();
        Type collectionType = new TypeToken<Collection<MyCustomClass>>(){}.getType();
        Collection<MyCustomClass> myCustomClasses = gson.fromJson(json, collectionType);
        System.out.println(myCustomClasses);
    }
}