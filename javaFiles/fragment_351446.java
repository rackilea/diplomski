private static void deleteKeyAndSub(int hkey, String key) 
    throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
  List<String> ls = WinRegistry.readStringSubKeys(hkey, key);
  if(ls == null) {
    return;
  } else if(ls.isEmpty()) {
    WinRegistry.deleteKey(hkey, key);
  } else {
    for (String subkey : ls) {
      subkey = key+"\\"+subkey;
      //System.out.println("delete subkey - "+subkey);
      deleteKeyAndSub(hkey, subkey);
    }
    WinRegistry.deleteKey(hkey, key);
  }
}