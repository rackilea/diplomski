try
{
    client = new GreetingClient();  // Sets client OR throws an exception
}
catch(IOException e)
{
    e.printStackTrace();            // If exception print it
                                    // and continue happily with `client` unset 
}