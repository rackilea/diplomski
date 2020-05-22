if (process != null) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                DataOutputStream out = new DataOutputStream(
                        process.getOutputStream());
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(out));
                bw.write("feed your process with data ...");
                bw.write("feed your process with data ...");
                out.close();
            } catch (Exception e) {
                // handle exception here ...
            }
        }
    }).start();
}