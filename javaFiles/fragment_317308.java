import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity2 extends Activity {

    TextView intrebare;
    EditText raspuns;
    Button buton;
    TextView rasplata;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        intrebare = findViewById(R.id.intrebare);
        raspuns = findViewById(R.id.raspuns);
        buton = findViewById(R.id.button);
        rasplata = findViewById(R.id.rasplata);
    }

}