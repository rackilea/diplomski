class PrimeRunnable implements Runnable {
    HttpDownloadUtility scaricatore; //instance of the "downloader" class
    String path1, path2;

    PrimeRunnable(HttpDownloadUtility scaricatore,String path1,String path2) {
        this.scaricatore = scaricatore;
        this.path1 = path1;
        this.path2 = path2;
    }

    public void run() {
        try {
            scaricatore.downloadMedia(path1, path2); //method of the "downloader" class that takes 2 paths in input and downloads from the 1st and put the file downloaded in the 2nd path
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}