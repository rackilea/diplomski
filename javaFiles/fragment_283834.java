Thread thread = new Thread()
{
    @override
    public void run()
    {
        System.out.println("I'm a Thread");
    }
};
thread.start();