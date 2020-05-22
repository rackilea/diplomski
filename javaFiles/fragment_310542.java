public class WorkerRSR extends SwingWorker<String, Void>{
    private String urlFrames;
    private String urlImg;
    private int bool;
    private int dist;
    private int numI;
    private int spra;
    private boolean isCoda;
    private int numCoda;
    private String algo;

    public WorkerRSR(String urlImg, int dist, int numI, int spra, String algo, String urlFrames, boolean isCoda, int numCoda) {
        this.urlImg=urlImg;
        this.dist=dist;
        this.numI=numI;
        this.spra=spra;
        this.algo=algo;
        this.urlFrames=urlFrames;
        this.isCoda = isCoda;
        this.numCoda = numCoda;

//FIRST CHECK POINT

    }

    ...
}