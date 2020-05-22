// You need to use this import
//import android.preference.PreferenceManager;
SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

// Read previous value. If not found, use 0 as default value.
int count = prefs.getInt("count_key", 0);

// because you need to show the badge again, it means you need
// to increment the count
count = count + 1;

// Then apply it
ShortcutBadger.applyCount(context, count);

// After that, you need to save the value again for another badge count
SharedPreferences.Editor editor = prefs.edit();
editor.putInt("count_key", count);
editor.commit();