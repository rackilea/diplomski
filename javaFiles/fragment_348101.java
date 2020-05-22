public OpenCashDrawer() {
    SwingWorker worker = new SwingWorker<String, Void>() {

        public String doInBackground() {
            try {
                String sql = "INSERT INTO pos_cashdraw SET user_id='"+global_variables.user_id+"', message='Opened For Sale'";
                mysql_query.update_mysql(variables.con.conn, sql);
                String out = "";
                do {
                    out = "";
                    //System.out.println("opened cashdraw");
                    //String openDrawerCommand = "\u001B\u0070\u0030\u0042\u0045";
                    String openDrawerCommand2 = "\u0017";
                    //String cmd = "echo -e " + openDrawerCommand2 + " > /dev/usblp0";
                    String cmd = "echo -e " + openDrawerCommand2 + " > /dev/ttyS0";
                    ProcessBuilder pb = new ProcessBuilder("bash", "-c", cmd);

                    pb.redirectErrorStream(true);
                    if (pb != null) {
                        Process shell = pb.start();
                        InputStream shellin = shell.getInputStream();
                        int c;
                        while ((c = shellin.read()) != -1) {
                            System.out.write(c);
                            out += (char) c;
                        }
                        shellin.close();
                    }
                } while (out.contains("busy"));
            } catch (IOException ex) {
                System.err.println("Not supported in your operating system");
            }
            return "Opened";
        }
    };
    worker.execute();
}