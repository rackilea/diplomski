private static ClassLoader findClassLoader() {
            ClassLoader cl;
            if (System.getSecurityManager() == null) {
                cl = Thread.currentThread().getContextClassLoader();
            } else {
                cl = java.security.AccessController.doPrivileged(
                    new java.security.PrivilegedAction<ClassLoader>() {
                        public ClassLoader run() {
                            return Thread.currentThread().getContextClassLoader();
                        }
                    }
                );
            }
            if (cl == null) {
                cl = LogManager.class.getClassLoader();
            }

            return cl;
        }