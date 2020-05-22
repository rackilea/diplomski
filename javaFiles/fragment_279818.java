public Boolean execCommand(String command) 
{
    try {
        Runtime rt = Runtime.getRuntime();
        Process process = rt.exec("su");

        // capture stdout
        BufferedReader stdout = new BufferedReader(
            new InputStreamReader(process.getInputStream()));
        // capture stderr
        BufferedReader stderr = new BufferedReader(
            new InputStreamReader(process.getErrorStream()));

        DataOutputStream os = new DataOutputStream(process.getOutputStream()); 
        os.writeBytes(command + "\n");
        os.flush();

        String line = null;
        StringBuilder cmdOut = new StringBuilder();
        while ((line = stdout.readLine()) != null) {
            cmdOut.append(line);
        }
        stdout.close();
        while ((line = stderr.readLine()) != null) {
            cmdOut.append("[ERROR] ").append(line);
        }
        stderr.close();

        // Show simple dialog
        Toast.makeText(getApplicationContext(), cmdOut.toString(), Toast.LENGTH_LONG).show();

        os.writeBytes("exit\n");
        os.flush();

        // consider dropping this, see http://kylecartmell.com/?p=9
        process.waitFor(); 
    } catch (IOException e) {
        return false;
    } catch (InterruptedException e) {
        return false;
    }
    return true;
}