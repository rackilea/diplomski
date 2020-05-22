public static void superSu() {
        try {

            Process proc = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(proc.getOutputStream());

            os.writeBytes("service call phone 5\n");
            os.flush();

            os.writeBytes("exit\n");
            os.flush();

            Thread.currentThread().interrupt();//close current thread 

            if (proc.waitFor() == 255) {
                // TODO handle being declined root access
                // 255 is the standard code for being declined root for SU
            }
        } catch (IOException e) {
            // TODO handle I/O going wrong
            // this probably means that the device isn't rooted
        } catch (InterruptedException e) {
            // don't swallow interruptions
            Thread.currentThread().interrupt();
        }
    }