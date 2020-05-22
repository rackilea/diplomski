import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton; // this is the important part
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// activity name changed!
public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioSexGroup = findViewById(R.id.radioSex);
        btnDisplay = findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioSexGroup.getCheckedRadioButtonId();
                radioSexButton = findViewById(selectedId);

                // find the radiobutton by returned id
                Toast.makeText(getApplicationContext(),
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}