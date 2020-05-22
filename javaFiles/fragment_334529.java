public class ResultChecker implements Runnable{
    private DrawView drawView;
    private volatile Result r;

    public ResultChecker(DrawView drawView){
        this.drawView = drawView;
        this.r = null;
    }

    public Result poll() {
        return r;
    }

    public void run() {
        boolean run = true;
        while(run){
            if(drawView.isNextQuestion()){
                //RETURN VALUE HERE
                r = someObject;
                // once r has been assigned, you cannot touch it again
                // or the object it refers to from this thread because
                // there are no locks
                run = false;
            }
        }
    }

}