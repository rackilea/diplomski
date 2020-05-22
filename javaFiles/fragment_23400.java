if (!Arrays.asList(ip, port, username, password).contains(newSet))
{
    saveButton.setEnabled(true);
}
else
{
    saveButton.setEnabled(false);
}