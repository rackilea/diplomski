public abstract class CameraParent
{
    public abstract void init();
    public abstract void start();
    public abstract void stop();
    public abstract void release();

    public virtual Runnable initAsync()
    {
        Runnable r = new Runnable()
        {
            @Override
            public void Run()
            {
                init();
            }
        }
        return r;
    }

    public virtual Runnable startAsync()
    {
        Runnable r = new Runnable()
        {
            @Override
            public void Run()
            {
                start();
            }
        }
        return r;
    }

    public virtual Runnable stopAsync()
    {
        Runnable r = new Runnable()
        {
            @Override
            public void Run()
            {
                stop();
            }
        }
        return r;
    }

    public virtual Runnable releaseAsync()
    {
        Runnable r = new Runnable()
        {
            @Override
            public void Run()
            {
                release();
            }
        }
        return r;
    }
}