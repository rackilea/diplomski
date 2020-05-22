import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView tv;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickHandler(View v) {
        tv = (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button1);
        System.out.println("tv = " + tv.getText());
        tv.setText("lol");

    }
    }