public static int showConfirmDialog(Component parentComponent,
                    Object message,
                    String title,
                    int optionType)
                             throws HeadlessException

Brings up a dialog where the number of choices is determined by the optionType parameter.

Parameters:
    parentComponent - determines the Frame in which the dialog is displayed; if null, or if the parentComponent has no Frame, a default Frame is used
    message - the Object to display
    title - the title string for the dialog
    optionType - an int designating the options available on the dialog: YES_NO_OPTION, YES_NO_CANCEL_OPTION, or OK_CANCEL_OPTION
Returns:
    an int indicating the option selected by the user