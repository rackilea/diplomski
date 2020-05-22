import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * A simple implementation for the preferences API. That stores preferences
 * in propery files. We do not have to worry about sharing the preferencese 
 * with other JVM instance so there is no need for any kind of synchronising
 * or locking.
 */
public class PropertyPreferences extends AbstractPreferences {