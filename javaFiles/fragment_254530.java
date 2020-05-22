Socket s = new Socket();
try
{
    s.connect(address, timeout);
}
catch (SocketTimeoutExceptione exc)
{
    // connect timeout
}