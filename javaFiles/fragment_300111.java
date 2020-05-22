ProcessBuilder pb = new ProcessBuilder("ls", "~");
    pb.redirectErrorStream(true);

    try {
        Process p = pb.start();
        InputStream is = null;
        try {
            is = p.getInputStream();
            int in = -1;
            while ((in = is.read()) >= 0) {
                System.out.print((char) in);
            }
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
            }
        }
        System.out.println("Exited with " + p.waitFor());
    } catch (IOException exp) {
        exp.printStackTrace();
    } catch (InterruptedException exp) {
        exp.printStackTrace();
    }