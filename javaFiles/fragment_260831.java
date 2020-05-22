import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.content.res.Resources;
import android.util.Log;

public class MainActivity extends Activity {

  private String TAG = "MainActivity";

  private Activity mActivity;
  private Spinner mCitySpinner;
  private Spinner mAreaSpinner;

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);

    setContentView(R.layout.activity_main);

    Log.d(TAG, "onCreate");

    mActivity = this;

    mCitySpinner = (Spinner)findViewById(R.id.citySpinner);
    mAreaSpinner = (Spinner)findViewById(R.id.areaSpinner);

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
    mCitySpinner.setAdapter(adapter);
  }

  @Override
  public void onStart(){
    super.onStart();

    Log.d(TAG, "onStart");

    mCitySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
          Log.d(TAG, "mCitySpinner.onItemSelected");

          String city = mCitySpinner.getSelectedItem().toString();
          Log.d(TAG, String.format("city:%s", city));

          String name = String.format("%s_area", city).toLowerCase();
          Log.d(TAG, String.format("name:%s", name));

          String packageName = getPackageName();
          Log.d(TAG, String.format("packageName:%s", packageName));

          Resources res = getResources();
          int rid = res.getIdentifier(name, "array", packageName);
          Log.d(TAG, String.format("rid:%d", rid));

          String[] items = res.getStringArray(rid);
          ArrayAdapter<String> adapter = new ArrayAdapter<String>(mActivity, android.R.layout.simple_spinner_item, items);
          mAreaSpinner.setAdapter(adapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
          Log.d(TAG, "mCitySpinner.onNothingSelected");

          String[] items = new String[]{};
          ArrayAdapter<String> adapter = new ArrayAdapter<String>(mActivity, android.R.layout.simple_spinner_item, items);
          mAreaSpinner.setAdapter(adapter);
        }
    });

  }  
}