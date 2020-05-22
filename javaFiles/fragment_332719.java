public boolean isAllowed(String name,
                         String meta,
                         DeadboltHandler deadboltHandler,
                         Http.Context context)
{
    Subject subject = deadboltHandler.getSubject();
    result = // check your user's access to the page key (provided as the meta argument)
    return result;
}