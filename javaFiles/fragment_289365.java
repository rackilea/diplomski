/**
 * Created by KHEMRAJ on 7/13/2017.
 */
import android.content.Context;
import android.widget.Toast;

public class Helper {
    public static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    public static final String ITEM_ONE_ID = "android.test.purchased";
    public static final String ITEM_TWO_ID = "2";
    public static final String ITEM_THREE_ID = "3";
    public static final String ITEM_FIVE_ID= "4";
    public static final String ITEM_SIX_ID = "5";
    public static final int RESPONSE_CODE = 1001;

    public static void displayMessage(Context context, String message){
        Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}