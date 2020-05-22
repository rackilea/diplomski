// run command with su rights and return output of that command(inside su
// shell)
// command = "ls /data"
public static void suOutputExecute(String command) {
    try {
        int BUFF_LEN = 1024;
        Process p = Runtime.getRuntime().exec(new String[] { "su", "-c", "system/bin/sh" });
        DataOutputStream stdin = new DataOutputStream(p.getOutputStream());
        // from here all commands are executed with su permissions
        stdin.writeBytes(command + "\n"); // \n executes the command
        InputStream stdout = p.getInputStream();
        byte[] buffer = new byte[BUFF_LEN];
        int read;
        String out = new String();
        // while((read=stdout.read(buffer))>0) won't work here
        while (true) {
            read = stdout.read(buffer);
            out += new String(buffer, 0, read);
            if (read < BUFF_LEN) {
                // we have read everything
                break;
            }
        }
        stdout.close();
        Log.e("ROOT", out);
        p.waitFor();
    } catch (Exception e) {
        Log.e("ROOT", "Error", e);
    }
}