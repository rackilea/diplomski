private class BlinkTask extends TimerTask
{
    public void run()
    {
        reading.setVisible(!reading.isVisible());
    }
}