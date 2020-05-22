import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MyAndroidAppActivity extends Activity {

  private RadioGroup radioGroup;
  private RadioButton radioButton;
  private Button btnDisplay;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    addListenerOnButton();

  }

  public void addListenerOnButton() {

    radioGroup = (RadioGroup) findViewById(R.id.radio);
    btnDisplay = (Button) findViewById(R.id.btnDisplay);

    btnDisplay.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

                // get selected radio button from radioGroup
            int selectedId = radioGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            radioButton = (RadioButton) findViewById(selectedId);

            Toast.makeText(MyAndroidAppActivity.this,
                radioButton.getText(), Toast.LENGTH_SHORT).show();

        }

    });

  }
}