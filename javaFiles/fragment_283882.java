AtomicBoolean buttonIsPressed = new AtomicBoolean( false );

public void mousePressed( MouseEvent e ) 
{
    if( ((e.getButton() == 1)
        && (e.getX() >= Playx1 && e.getX() <= Playx1 + Playw1 && e.getY() >= Playy1 && 
        e.getY() <= Playy1 + Playh1))
        && !buttonIsPressed.compareAndExchange( false, true ) ) 
    {
        System.out.println("Test Text, Replace line with method later");
    }
}

public void mouseReleased( MouseEvent e ) 
{
    if( e.getButton() == 1 ) 
    {
        buttonIsPressed.compareAndExchange( true, false );
    }
}