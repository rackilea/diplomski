import java.lang.reflect.Field;

import android.util.Log;

public class ResourceUtil {

/**
 * Finds the resource ID for the current application's resources.
 * @param Rclass Resource class to find resource in. 
 * Example: R.string.class, R.layout.class, R.drawable.class
 * @param name Name of the resource to search for.
 * @return The id of the resource or -1 if not found.
 */
public static int getResourceByName(Class<?> Rclass, String name) {
    int id = -1;
    try {
        if (Rclass != null) {
            final Field field = Rclass.getField(name);
            if (field != null)
                id = field.getInt(null);
        }
    } catch (final Exception e) {
        Log.e("GET_RESOURCE_BY_NAME: ", e.toString());
        e.printStackTrace();
    }
    return id;
}