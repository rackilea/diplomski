public static void executeCommands() throws IOException {


            ProcessBuilder pb = new ProcessBuilder("bash", "./shell.sh");
            pb.inheritIO();
            Process process = pb.start();

                try {
                    process.waitFor();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

    }