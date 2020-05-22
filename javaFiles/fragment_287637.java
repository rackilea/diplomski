public static void showOnScreen( int screen, JFrame frame )
{
    GraphicsEnvironment ge = GraphicsEnvironment
        .getLocalGraphicsEnvironment();
    GraphicsDevice[] gs = ge.getScreenDevices();
    if( screen > -1 && screen < gs.length )
    {
        gs[screen].setFullScreenWindow( frame );
    }
    else if( gs.length > 0 )
    {
        gs[0].setFullScreenWindow( frame );
    }
    else
    {
        throw new RuntimeException( "No Screens Found" );
    }
}