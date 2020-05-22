package some.package;

import android.app.Activity;
import android.os.Bundle;

public class GimmeReturn extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toast.makeText(this, "Returning!", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }
}