@Before(value = "@Login")
public void loginIfNeeded()
{
    // check you are logged in, if you are, do not login
    // if you are not logged in, perform login procedure.
}