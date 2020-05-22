public static boolean inOSGi() {
  try {
   Class.forName("org.osgi.framework.FrameworkUtil");
   return true;
  }
  catch (ClassNotFoundException e) {
   return false;
  }
 }