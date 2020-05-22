public class Chainer
{
    public Chainer doStuff()
    {
       /* Do stuff ... */
       return this;
    }
}

public class ChainerExtender extends Chainer
{
    @Override
    public ChainerExtender doStuff()
    {
       /* Do stuff ... */
       super.doStuff();
       return this;
    }
}