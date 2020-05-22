import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;

/**
 * Own implementation of the Java preferences API, that does not use
 * a "OS backing store" but relies on importing and exporting the
 * preferences via xml files.
 * Also, If a preference is got, but was not in the tree, it is entered.
 */
public class MyPreferences extends AbstractPreferences {

    private Map<String, String> prefs = new HashMap<String, String>();
    private Map<String, AbstractPreferences> children = new HashMap<String, AbstractPreferences>();

  public MyPreferences(MyPreferences parent, String name) {
    super(parent, name);
  }

  /**
   * @see java.util.prefs.AbstractPreferences#putSpi(java.lang.String, java.lang.String)
   */
  protected void putSpi(String key, String value) {
    prefs.put(key, value);
  }