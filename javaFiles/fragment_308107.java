import android.content.Context;
import android.content.SharedPreferences;

import com.xenicdev.locationtimer.MainActivity;

public class AssetLoader {
    private static SharedPreferences prefs;

    public static void load() {

        // Prefs
        prefs = MainActivity.getContext().getSharedPreferences("LocationTimer", Context.MODE_PRIVATE);
        if(!prefs.contains("totalLocations")) {
            prefs.edit().putInt("totalLocations", 0).apply();
        }
    }

    public static void setTotalLocations(int totalLocations) {
        prefs.edit().putInt("totalLocations", totalLocations).apply();
    }

    public static Integer getTotalLocations() {
        return prefs.getInt("totalLocations", 0);
    }

    public static void setItemDetails(String id, String details) {
        prefs.edit().putString(id, details).apply();
    }

    public static String getItemDetails(String id) {
        return prefs.getString(id, "");
    }
}