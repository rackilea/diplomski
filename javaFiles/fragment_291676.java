private static final String MESSAGE_PREFIX =
    "[Microsoft][ODBC SQL Server Driver][SQL Server]";

...

String message = exception.getMessage();
if (message.startsWith(MESSAGE_PREFIX))
{
    message = message.substring(MESSAGE_PREFIX.length());
}