public boolean exists() {
             SecurityManager security = System.getSecurityManager();
             if (security != null) {
                 security.checkRead(path);
             }
             return ((fs.getBooleanAttributes(this) & FileSystem.BA_EXISTS) != 0);
         }