public static void main2(String[] args) {
    FileReader fr = null;
    int permits = 256;
    Semaphore l = new Semaphore(permits);
    try {
        fr = new FileReader("the-file-name.txt");
        BufferedReader br = new BufferedReader(fr);
        String sCurrentLine;
        long time1 = System.currentTimeMillis();
        while ((sCurrentLine = br.readLine()) != null) {
            l.acquire();
            session.executeAsync(sCurrentLine)
                .addListener(()->l.release(), MoreExecutors.directExecutor());
        }
        l.acquire(permits);

        System.out.println(System.currentTimeMillis() - time1);
        fr.close();
        br.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}