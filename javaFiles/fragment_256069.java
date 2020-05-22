Connection connection;
// ...
SQLWarning warn = connection.getWarnings();
int errorCode = warn.getErrorCode();
if (errorCode == 28011) {
  // ORA-28011
} else if (errorCode == 28002) {
  // ORA-28002
}