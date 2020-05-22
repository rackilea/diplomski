private void closeProgram(WindowEvent event)
{
    if (logic.unsavedChangesExist())
    {
        if (showWarningWindow("You currently have unsaved changes made to the database."
                + "\nAre you sure you would like to exit without saving?"))
        {
            Platform.exit();
        } else {
            event.consume();
        }
    }
}