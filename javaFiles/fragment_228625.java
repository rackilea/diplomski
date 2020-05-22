Thread t = new Thread(new Runnable() {
    private String s;

    @Override
    public void run() {
        try {

            Component selectedComponent = jTabbedPane2.getSelectedComponent();
            if (selectedComponent instanceof MyTextArea) {
                String response = "";
                System.out.println("yes");
                MyTextArea temptextarea = (MyTextArea) selectedComponent;
                String xpiPath = new File(temptextarea.getNameX()).getParentFile().getPath();

                String[] commands = {"C:\\Users\\Madhawa.se\\Desktop\\workingfox\\runner\\foxrun.bat", "C:\\mozilla-build\\addon-sdk-1.16\\bin\\activate.bat

                ProcessBuilder process = new ProcessBuilder(commands);
                process.redirectErrorStream(true);

                Process shell = process.start();

                //shell.waitFor();
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(shell.getInputStream()));
                BufferedReader stdError = new BufferedReader(new InputStreamReader(shell.getErrorStream()));

                // read the output from the command
                System.out.println("Here is the standard output of the command:\n");
                while ((s = stdInput.readLine()) != null) {
                    System.out.println("s:" + s);
                }

                // read any errors from the attempted command
                System.out.println("Here is the standard error of the command (if any):\n");
                while ((s = stdError.readLine()) != null) {
                    System.out.println("w:" + s);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }