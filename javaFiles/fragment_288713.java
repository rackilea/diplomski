public void threads() throws IOException {
    final PipedOutputStream outputForMainThread = new PipedOutputStream();
    new Thread(new Runnable() {
        @Override
        public void run() {
            while(moreDataOnNetwork()) {
                byte[] data = readDataFromNetwork();
                try {
                    outputForMainThread.write(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
    BufferedReader reader = new BufferedReader(new InputStreamReader(new PipedInputStream(outputForMainThread)));
    for(String eachLine = reader.readLine(); eachLine != null; eachLine = reader.readLine()) {
        System.out.println(eachLine);
    }
}