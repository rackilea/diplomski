@Override
public void onEvent( IEvent<?> event )
{
    Object payload = event.getPayload();

    @SuppressWarnings( "rawtypes" )
    Class clazz = payload.getClass();

    //or use isAssignableFrom() or instanceof or any method you like
    if ( CheeseAddedEvent.class.equals( clazz ) )
    {
        CheeseAddedEvent e = ( (CheeseAddedEvent) payload );
        e.target.add( this );
    }
    super.onEvent(event);
}