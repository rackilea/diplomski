Platform.runLater(new Runnable()
{
    @Override
    public void run()
    {
        table.requestFocus();
        table.getSelectionModel().select(0);
        table.getFocusModel().focus(0);
    }
});