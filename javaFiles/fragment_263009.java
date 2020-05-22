new Thread(new Runnable() {
        public void run() {

            try {
                // Send script into runtime process
                Process process = Runtime.getRuntime().exec(pingCommand);

                // ......

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // .....
            }
        }
    }).start();
}