try
{
        Do something from java standard. //Class.forName(dbObject.getDriver());  
} if an exception occures, go in this block //catch (Exception e) 
{
        Just print out the exception. 
        If someone knowns about your application he'll take a look in the log. 
        If not, your exception is lost, after leaving this block.
        And I think here is your problem!
        Do not catch any exceptions in a so low level of your application.
}