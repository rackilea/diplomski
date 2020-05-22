public void login(String nickname, char[] password) {
    if (cl == null) {
        throw new RuntimeException();
    }
    long s = Sys.getTime();
    cl.send("NICK " + nickname);
    IncomingMessage reply = null;
    try {
        reply = this.mh.getMessage(); //The response to NICK msg
        if (reply.getCommand().equalsIgnoreCase("LOGIN")) {
            ArrayList<String> params = reply.getParams();
            String accountSalt = params.get(0);
            String randomSalt = params.get(1);
            try {
                String sharedSecret = SHAHash.digestSalted(accountSalt, password);
                String saltedSharedSecret = SHAHash.digestSalted(randomSalt, sharedSecret);
                if (saltedSharedSecret != null) {
                    cl.send("PASS " + saltedSharedSecret);
                    reply = this.mh.getMessage();
                    if (reply.getCommand().equalsIgnoreCase("WELCOME") && reply.getParams().get(0).equals(nickname)) {
                        // ************ LOG ************ //
                        LOG.config("Logged in.");
                        // ***************************** //
                        this.running = true;
                        this.loggedIn = true;
                        mh.startExecutor();
                        LOG.config("Time passed: " + (Sys.getTime() - s));
                        mh.startGame();
                    } else {
                        // ************ LOG ************ //
                        LOG.warning("A problem has occured while trying to login to the server.");
                        // ***************************** //
                        JOptionPane.showMessageDialog(null, "Error while logging to the server, shutting down.\n- ERROR 006 -");
                        System.exit(0);
                    }
                }
            } catch (NoSuchAlgorithmException e) {
                // ************ LOG ************ //
                LOG.warning("Error while SHA hashing the password, shutting down.");
                // ***************************** //
                JOptionPane.showMessageDialog(null, "Error while SHA hashing the password, shutting down.\n- ERROR 005 -");
                System.exit(0);
            }
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}