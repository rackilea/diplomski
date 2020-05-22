private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
private ScheduledFuture<?> timerFuture = null;

void toggleTimer()
{
    if (timerFuture != null)
    {
        // Stop the timer
        timerFuture.cancel();
        timerFuture = null;
    } else
    {
        // Start the timer on the separate thread, run it every second
        timerFuture = executor.scheduleAtFixedRate((Runnable) () -> {
            minutes = minutes + 1;
            if (minutes > 59)
            {
                minutes = 0;
                hours = hours + 1;
            }
            if (hours > 23)
            {
                hours = 0;
            }
            // Update the UI, this needs to be done on the UI thread
            SwingUtilities.invokeLater(() -> {
                display.setText(String.format("%02d:%02d", hours, minutes));
                display.repaint();
            });
        }, 0, 1, TimeUnit.SECONDS);
    }
}