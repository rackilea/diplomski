public static boolean isTrusted() {
     SecurityManager security = System.getSecurityManager();
     if (security == null) {
         return true;
     } else {
         try {
             security.checkPermission(new AllPermission());
             return true;
         } catch (SecurityException exc) {
             return false;
         }
     }
}