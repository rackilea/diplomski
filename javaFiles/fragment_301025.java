try 
{
    // some hibernate calls
} 
catch (GenericJdbcException ge) 
{
    if(ge.getCause() != null && ge.getCause() instanceof SQLException) 
    {
        SQLException se = (SQLException)ge.getCause();

        // *****************************************************************
        // NOTE: THIS will be where you check for your customer error code.
        // *****************************************************************
        if(se.getErrorCode() == -20001) 
        {
            // your error handling for this case
        }
        else
        {
            throw ge; // do not swallow unhandled exceptions
        }
    }
    else
    {
        throw ge // do not swallow unhandled exceptions
    }
}