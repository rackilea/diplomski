Thread t = new Thread()
{
    public void run()
    {
        //Start service
        getApplicationContext().bindService(
                    new Intent(getApplicationContext(), SimpleVoiceService.class), 
                    serviceConnection,
                    Context.BIND_AUTO_CREATE);

    }
};
t.start();