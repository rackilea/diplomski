ProxySelector sel =
    java.security.AccessController.doPrivileged(
      new java.security.PrivilegedAction<ProxySelector>() {
        public ProxySelector run() {
          return ProxySelector.getDefault();
        }
      });