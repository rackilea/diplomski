import java.util.concurrent.atomic.AtomicLong;

public class AtomicIdGenerator
{
    private static class SingletonHolder
    {
        public static final AtomicIdGenerator instance = new AtomicIdGenerator();
    }

    public static AtomicIdGenerator getInstance()
    {
        return SingletonHolder.instance;
    }

    private AtomicLong mIdGenerator = null;

    private AtomicIdGenerator()
    {
        mIdGenerator = new AtomicLong();
    }

    private AtomicLong getGenerator()
    {
        return mIdGenerator;
    }

    public long getNewId()
    {
        return getGenerator().incrementAndGet();
    }
}