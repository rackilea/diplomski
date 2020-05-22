package cases

import support.tool.AutotestResult;
import sources.Another

public class Another2 extends Another
{
    public Another2()
    {
        this.setName(this.name+"N");
    }
    public AutotestResult run()
    {
        return new AutotestResult(this.name+"123",this.getResult(),null,null)
    }
}
Another2 a = new Another2()
a.run()