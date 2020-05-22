public class MessageBean implements Serializable
{

   transient private static ResourceBundle bundle;
   transient private static Map map;

protected static ClassLoader getCurrentClassLoader(Object defaultObject)
{
  ClassLoader loader = Thread.currentThread().getContextClassLoader();
  if (loader == null)
  {
     loader = defaultObject.getClass().getClassLoader();
  }
  return loader;
}

MessageBean()
{
  bundle = ResourceBundle.getBundle("LanguageChances", java.util.Locale.getDefault(), getCurrentClassLoader(null));
  map = new HashMap<String, Object>();
  Enumeration<String> keys = bundle.getKeys();
  while (keys.hasMoreElements()) {
      String key = keys.nextElement();
      Object value = bundle.getObject(key);
     map.put(key, value);
  }
}

public Map getMap(){
  return map;
}
}