public abstract static class SwingTask implements Runnable
{
    public void start()
    {
         SwingUtilities.invokeLater( this );
    }
}

startDownload() {
    new SwingTask() { public void run() {
        label.setText("Download started");
    } }.start();
}