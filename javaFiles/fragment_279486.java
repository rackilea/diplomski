InputStream responseStream = null;
int responseCode = -1;
IOException exception = null;
try
{
    responseCode = connection.getResponseCode();  
    responseStream = connection.getInputStream();
}
catch(IOException e)
{
    exception = e;
    responseCode = connection.getResponseCode();  
    responseStream = connection.getErrorStream();    
}

// You can now examine the responseCode, responseStream, and exception variables
// For example:

if (responseStream != null)
{
    // Go ahead and examine responseCode, but
    // always read the data from the responseStream no matter what
    // (This clears the connection for reuse).
    // Probably log the exception if it's not null
}
else
{
    // This can happen if e.g. a malformed HTTP response was received
    // This should be treated as an error.  The responseCode variable
    // can be examined but should not be trusted to be accurate.
    // Probably log the exception if it's not null
}