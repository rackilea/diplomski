public final void run() {
    exec = Executors.newSingleThreadScheduledExecutor();
    exec.scheduleAtFixedRate(new Runnable() {
        public void run() {
            final Calendar cal = Calendar.getInstance();
            try {

                if (cal.get(Calendar.DAY_OF_WEEK) == 1 || cal.get(Calendar.DAY_OF_WEEK) == 7) {
                    Globals.addMessage("Non-scheduled work day, please try again later.");
                    Globals.addMessage("Process aborted.");
                    running = false;

                }
                else if (cal.get(Calendar.HOUR_OF_DAY) < 6 || cal.get(Calendar.HOUR_OF_DAY) > 20) {
                    Globals.addMessage("Non-scheduled work hours, please try again later.");
                    Globals.addMessage("Process aborted.");
                    running = false;

                }
                else {
                    running = true;
                    Runtime rt = Runtime.getRuntime();
                    rt.exec(ServerVar.getVariable(ServerVars.PATH));
                    Globals.addMessage("Program is running.");
                }
            }
            catch (IOException e) {
                Globals.addMessage(e.toString());

            }

        }
    }

        , 0, 30, TimeUnit.MINUTES);
}