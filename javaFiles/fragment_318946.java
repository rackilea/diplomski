try {

        String Path = "data/data/com.viber.voip/databases/viber_data";
        String args = "/system/bin/chmod 777 " + Path;

        String args1 = " sqlite3 -csv " + Path;

        String args2 = " SELECT _id,canonized_number from vibernumbers where _id >  12 LIMIT 1;";

        Command command = new Command(0, "su", args, args1, args2, ".exit") {
            @Override
            public void output(int id, String line) {
                 //Check result
            }

            @Override
            public void commandCompleted(int arg0, int arg1) {

            }

            @Override
            public void commandOutput(int arg0, String arg1) {
            }

            @Override
            public void commandTerminated(int arg0, String arg1) {
                String u = arg1;

            }
        };
        RootTools.getShell(true).add(command);
    } catch (Exception e) {
        e.getMessage();
    }