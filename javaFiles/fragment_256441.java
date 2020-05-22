private string FindInnerExceptionMessage(Exception ex)
{
    string exceptionMsg = string.Empty;
    if (ex.InnerException == null)
    {
        exceptionMsg = ex.Message;
    }
    else
    {
        exceptionMsg = FindInnerExceptionMessage(ex.InnerException);
    }
    return exceptionMsg;
}