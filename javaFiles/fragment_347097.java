try {
        Process process = Runtime.getRuntime().exec("su");

        DataOutputStream os = new DataOutputStream(process.getOutputStream());
        os.writeBytes("rm "+dest_file + "\n"); //removes destination file -might not be required - haven't tested
        os.flush();
        os.writeBytes("cat "+src_file+" > "+dest_file + "\n");
        os.flush();
        os.writeBytes("exit\n");
        os.flush();

        // Waits for the command to finish.
        process.waitFor();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    catch (InterruptedException e) {
        e.printStackTrace();
    }