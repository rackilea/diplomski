public void appendText(final String text) 
{
    executeOnEventDispatchThread(() -> textField.setText(text));
}

private static void executeOnEventDispatchThread(Runnable runnable)
{
    if (SwingUtilities.isEventDispatchThread())
    {
        runnable.run();
    }
    else
    {
        SwingUtilities.invokeLater(runnable);
    }
}