import android.app.Activity;
import android.os.Bundle;

public class AnotherScreen extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anotherScreen); 

    } 

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}