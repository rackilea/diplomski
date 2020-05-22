import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.???.???.R;

public class <YourClassname> extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Load the preferences from an XML resource
        setPreferencesFromResource(R.xml.<yourXmlFilename>, rootKey);
    }

}