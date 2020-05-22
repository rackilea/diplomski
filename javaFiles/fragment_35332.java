ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash");
processBuilder.redirectErrorStream(true);
try {
    final Process bash = processBuilder.start();
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(bash.getOutputStream()));

    new Thread(new Runnable() {
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bash.getInputStream()));
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }).start();
    bufferedWriter.write("echo say Serverbackup begins in 3...\n");
    bufferedWriter.flush();
    Thread.sleep(2000);
    bufferedWriter.write("echo say 2\n");
    bufferedWriter.close();

} catch (IOException e) {
    e.printStackTrace();
} catch (InterruptedException e) {
    e.printStackTrace();
}