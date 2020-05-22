class JarURLInputStream extends java.io.FilterInputStream {
        JarURLInputStream (InputStream src) {
            super (src);
        }
        public void close () throws IOException {
            try {
                super.close();
            } finally {
                if (!getUseCaches()) {
                    jarFile.close(); //will not close
                }
            }
        }
    }



    public void connect() throws IOException {
        if (!connected) {
            /* the factory call will do the security checks */
            jarFile = factory.get(getJarFileURL(), getUseCaches());

            /* we also ask the factory the permission that was required
             * to get the jarFile, and set it as our permission.
             */
            if (getUseCaches()) {
                jarFileURLConnection = factory.getConnection(jarFile);
            }

            if ((entryName != null)) {
                jarEntry = (JarEntry)jarFile.getEntry(entryName);
                if (jarEntry == null) {
                    try {
                        if (!getUseCaches()) {
                            jarFile.close();  //will not close
                        }
                    } catch (Exception e) {
                    }
                    throw new FileNotFoundException("JAR entry " + entryName +
                                                    " not found in " +
                                                    jarFile.getName());
                }
            }
            connected = true;
        }
    }