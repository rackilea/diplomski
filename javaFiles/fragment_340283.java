public Object start( IApplicationContext context )
    throws Exception
{
    Object result = super.start( context );

    Activator.getContext().getBundle( 0 ).stop();

    return result;
}