StringBuffer answer = new StringBuffer();
                BufferedReader reader;
                // This is needed as code called from Javascript does not have the rights to do this
                try
                {
                     reader = new BufferedReader(
                        AccessController.doPrivileged(
                            new PrivilegedExceptionAction<InputStreamReader>() {
                                public InputStreamReader run() throws IOException {
                                    return new InputStreamReader(conn.getInputStream());
                                }
                            }
                        )
                    );
                }
                catch (PrivilegedActionException e) {
                    // e.getException() should be an instance of IOException,
                    // as only "checked" exceptions will be "wrapped" in a
                    // PrivilegedActionException.
                    throw (IOException) e.getException();
                }