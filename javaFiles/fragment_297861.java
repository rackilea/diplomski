/*
     * @see java.applet.Applet#init()
     */
    public void init() {
        state = STATE_INIT;

        // sanity check
        String[] requiredArgs = {"al_main", "al_logo", "al_progressbar", "al_jars"};
        for(int i=0; i<requiredArgs.length; i++) {
            if(getParameter(requiredArgs[i]) == null) {
                fatalErrorOccured("missing required applet parameter: " + requiredArgs[i], null);
                return;             
                }

//...           }       
        }