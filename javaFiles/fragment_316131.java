package com.whatever.prefs;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
  public static final String SETTINGS = "com.whatever.prefs.settings";
  public static final String FIRST_USE = "com.whatever.prefs.firstUse";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    /* BAD IDEA--CREATES NEW SET OF PREFS 
    SharedPreferences preferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
    Do this v v v v v v v v v v v instead! */
    preferences = PreferenceManager.getDefaultSharedPreferences(this);

    boolean firstUse = preferences.getBoolean(FIRST_USE, true);
    if (firstUse){
      Toast helloMessage = Toast.makeText(getApplicationContext(), "Hello First Time 
                                    User",Toast.LENGTH_LONG);
      helloMessage.show();
      Editor editor = preferences.edit();
      editor.putBoolean(FIRST_USE, false);
      editor.commit();
    }
    else {
      Toast.makeText(getApplicationContext(), "Second+ use", Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
  }
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_settings:
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

        return true;

      default:
        return super.onOptionsItemSelected(item);
    }
  }
}