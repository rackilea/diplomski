private static class ResourceRefreshRunner implements Runnable
{
    WeakReference<Main> _weakRef;
    public ResourceRefreshRunner(Main o)
    {
        _weakRef = new WeakReference<Main>(o);
    }       
    @Override
    public void run() { 
        try {
            Main m = _weakRef.get();
            if (m != null) 
                m.shout(); 
            else 
                System.out.println("object not there, but future is running. ");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}