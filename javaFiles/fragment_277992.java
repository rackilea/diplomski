public class TestCrawler extends WebCrawler {

private Pause mPause;

public TestCrawler(Pause pPause) {
    this.mPause = pPause;
}

private SingleThread()
{
        //When this function is running, no other crawler should do anything
}

@Override
public void visit(Page page) {
    if(SomeCriteria())
    {
        //only enter the crucial part once if it has to be exclusive
        this.mPause.probe();
        //make all other crawlers stop until I finish
        this.mPause.pause(true);
        SingleThread();
        //let them resume
        this.mPause.pause(false);
    }
    this.mPause.probe();
    //Normal Stuff
}
}