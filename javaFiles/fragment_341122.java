OutputStreamWriter writer;
                // This is needed as code called from Javascript does not have the rights to do this
                try
                {
                    writer = 
                        AccessController.doPrivileged(
                            new PrivilegedExceptionAction<OutputStreamWriter>() {
                                public OutputStreamWriter run() throws IOException {
                                    return new OutputStreamWriter(conn.getOutputStream());
                                }
                            }
                        );
                }
                catch (PrivilegedActionException e) {
                    // e.getException() should be an instance of IOException,
                    // as only "checked" exceptions will be "wrapped" in a
                    // PrivilegedActionException.
                    throw (IOException) e.getException();
                }