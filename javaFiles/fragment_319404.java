import android.os.Bundle;
import android.view.View;

import com.akexorcist.localizationactivity.LocalizationActivity;

public class MainActivity extends LocalizationActivity implements View.OnClickListener {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple);

    findViewById(R.id.btn_th).setOnClickListener(this);
    findViewById(R.id.btn_en).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.btn_en) {
      setLanguage("en");
    } else if (id == R.id.btn_th) {
      setLanguage("th");
    }
  }
}