public static void shExecute(String[] commands) {
    Process shell = null;
    DataOutputStream out = null;
    BufferedReader in = null;

    try {
        // Acquire sh
        Log.i(LOG_TAG, "Starting exec of sh");
        shell = Runtime.getRuntime().exec("sh");//su if needed
        out = new DataOutputStream(shell.getOutputStream());

        in = new BufferedReader(new InputStreamReader(shell.getInputStream()));

        // Executing commands without root rights
        Log.i(LOG_TAG, "Executing commands...");
        for (String command : commands) {
            Log.i(LOG_TAG, "Executing: " + command);
            out.writeBytes(command + "\n");
            out.flush();
        }

        out.writeBytes("exit\n");
        out.flush();
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = in.readLine()) != null) {
            sb.append(line).append("\n");
        }
        Log.i(LOG_TAG, sb.toString());
        shell.waitFor();

    } catch (Exception e) {
        Log.e(LOG_TAG, "ShellRoot#shExecute() finished with error", e);
    } finally {
        try {
            if (out != null) {
                out.close();
            }
            if(in != null){
                in.close();
            }
            // shell.destroy();
        } catch (Exception e) {
            // hopeless
        }
    }
}