import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonTest
{

    public static void main ( String [ ] args )
    {
        String jsonInString = "{ \"d\": { \"result\" : [ \"hello\", \"Frank\", \"Provost\" ] } }";

        System.out.println ( "Printing JSON String" );
        System.out.println ( jsonInString );
        System.out.println (  );

        JsonParser parser =  new JsonParser();
        JsonObject jsonObject = parser.parse(jsonInString).getAsJsonObject().get("d").getAsJsonObject();
        JsonArray jsonArray =  jsonObject.get("result").getAsJsonArray();

        System.out.println ( "Printing result elements" );
        for( JsonElement property : jsonArray)
        {
            System.out.println ( property.getAsString ( ));
        }
        System.out.println (  );


        StagingUser user = new StagingUser ( );
        user.setHi ( jsonArray.get ( 0 ).getAsString ( ) );
        user.setName ( jsonArray.get ( 1 ).getAsString ( ) );
        user.setLastName ( jsonArray.get ( 2 ).getAsString ( ) );

        System.out.println ( "Printing POJO: " );
        System.out.println ( user.toString ( ) );
    }

}