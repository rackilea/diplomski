@Override
public void apply(Collection<ICompilationUnit> units)
{
    this.count = units.size();
    for (ICompilationUnit unit : units)
    {
        new Thread()
        {
            @Override
            public void run()
            {
                ParallelCompilerPhase.this.apply.accept(unit);
                ParallelCompilerPhase.this.count--;
            }
        }.start();
    }

    long now = System.currentTimeMillis();
    while (this.count > 0)
    {
        long l = System.currentTimeMillis() - now;
        if (l >= 1000L)
        {
            DyvilCompiler.logger.warning(this.name + " is taking too long! " + l + " ms");
            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        try
        {
            Thread.sleep(10L);
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}