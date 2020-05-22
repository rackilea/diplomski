catch (Throwable t) {
                Log.e(TAG, "Error preloading " + line + ".", t);
                if (t instanceof Error) {
                    throw (Error) t;
                }
                if (t instanceof RuntimeException) {
                    throw (RuntimeException) t;
                }
                throw new RuntimeException(t);
            }