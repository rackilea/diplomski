package izzy.n;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// actually you should name the class "Notes" since it's convention
// but it would proably cause errors since you have to rename the file then.
public class notes extends Activity {
    public static final String DEFAULT_TEXT = "Write some text here";
    public static final String PREFS_KEY_TEXT = "text";
    public static final String PREFS_NAME = "MyPrefsFile";

    private EditText mEditText;

    /**
     * Loads the text from SharedPreferences
     */
    private String loadText() {
        SharedPreferences settings = getSharedPreferences(notes.PREFS_NAME,
                Context.MODE_PRIVATE);
        return settings.getString(notes.PREFS_KEY_TEXT, notes.DEFAULT_TEXT);
    }

    /**
     * Saves text to SharedPreferences
     */
    private void saveText(String text) {
        SharedPreferences settings = getSharedPreferences(notes.PREFS_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(notes.PREFS_KEY_TEXT, text);
        editor.commit();
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes);

        // when you click on the button the app will exit
        // you kind of don't need such a button :)
        Button wg = (Button) findViewById(R.id.exit_button);
        wg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mEditText = (EditText) findViewById(R.id.edit_text);

        String savedText = loadText();
        mEditText.setText(savedText);
        // put the cursor to the end.
        mEditText.setSelection(savedText.length());
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveText(mEditText.getText().toString());
    }

}