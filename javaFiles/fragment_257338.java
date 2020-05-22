import com.google.gson.Gson;

public class Main
{
    public static void main(
        String[] args)
    {
        DataObject dataObject;
        final Gson gson = new Gson();
        final String nuttyJson = "{\"content\": { \"name1\": \"value1\", \"name2\": [ [ [\"string1\", \"string2\", 1], [\"string3\", \"string4\", 2] ], [ [\"string5\", \"string6\", 3], [\"string7\", \"string8\", 4] ] ], \"name3\": \"value3\" } }";

        dataObject = gson.fromJson(nuttyJson, DataObject.class);

        dataObject = null;
    }
}