public class ClipLooper extends Thread 
{
    private Clip c;
    private int firstFrame, lastFrame, numLoops, currentLoop = 1;

    public ClipLooper(Clip c, int ff, int lf, int nl) throws Exception
    {
        if( ff < 0 || lf < ff || c.getFrameLength() < lf)
            throw new Exception("you screwed up!! \n");
        this.c = c;
        firstFrame = ff;
        lastFrame = lf;
        numLoops = nl;
    }

    @Override
    public void run()
    {
        while(currentLoop <= numLoops || numLoops <= 0)
        {
            c.setFramePosition(firstFrame);

            c.start();
            c.loop(-1);

            while(c.getFramePosition() < lastFrame-220)
            {}

            c.stop();
            ++currentLoop;
        }
    }
}