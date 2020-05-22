rootSession.addCommand(new String[] { "ls -l /sdcard" },
    1, // a command id
    new Shell.OnCommandLineListener() {
        @Override
        public void onCommandResult(int commandCode, int exitCode) {
            // ...
        }
        @Override
        public void onLine(String line) {
            // ...
        }
    });