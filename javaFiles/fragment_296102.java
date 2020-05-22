/**
 * Type Converter to instruct Room how to serialize and deserialize List(s) of data
 */
public class ListConverter {

    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Icon> stringToIconList(String data) {

        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Icon>>() {}.getType();

        return gson.fromJson(data, listType);
    }


    @TypeConverter
    public static String iconListToString(List<Icon> list) {

        return gson.toJson(list);
    }
}