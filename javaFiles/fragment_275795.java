Runnable runnable = new Runnable()
{
    @Override
    public void run ( )
    {
        System.out.println( "Runnable running. " + ZonedDateTime.now( z ) );
    }
};