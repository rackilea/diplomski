Runnable serverRunnable = new Runnable()
{
    public void run()
    {
        create(Integer.parseInt(tf2.getText()));  //my func. to create server
    }
};
Thread serverThread = new Thread(serverRunnable);
serverThread.start();