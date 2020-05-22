Runtime.getRuntime().addShutdownHook(new Thread()
{
    @Override
    public void run()
    {
        updateZonas();
        db.close();
    }
});