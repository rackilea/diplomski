import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends Activity {

    private static JSONArray itemRows = null;
    private static String input =
            "[[\"c1_r1\", \"c1_r2\", \"c1_r3\"]," +
            "[\"c2_r1\", \"c2_r2\", \"c2_r3\"]," +
            "[\"c3_r1\", \"c3_r2\", \"c3_r3\"]]";
    private static String[][] output = new String[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // build the Array[][] from the encoded JSON
        try {
            itemRows = new JSONArray(input);
            Log.v("TestJSON","items.length=" + itemRows.length());
            Log.v("TestJSON","input=" + input);
            for(int i=0; i<itemRows.length(); i++){
                JSONArray tmpR = itemRows.getJSONArray(i);
                Log.v("TestJSON","i=" + i + " value=" + tmpR.toString());
                // Loop over each row
                Log.v("TestJSON","tmpR.length=" + tmpR.length());
                for(int j=0; j<tmpR.length(); j++){
                    String tmpC = tmpR.get(j).toString();
                    output[i][j] = tmpC;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}