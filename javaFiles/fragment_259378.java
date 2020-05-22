AccessController.doPrivileged(new PrivilegedAction() {

                @Override
                public Object run() {
                    try {
                        deleteAppCacheDirectory();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

            });