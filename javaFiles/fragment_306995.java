yourFrame.addWindowListener(new WindowAdapter()
{
    public void windowClosed(WindowEvent e)
    {
        screenshotThread.stopTakingScreenshots(); // This methods set the flag
    }
}