(new Thread( )
    {
        @Override
        public void run( )
        {
            try
            {
                java.awt.Robot robot = new Robot();
                robot.delay( 100 );
                robot.keyPress( KeyEvent.VK_F24 );
                robot.keyRelease( KeyEvent.VK_F24 );
            }
            catch ( Exception e )
            {
            }
        }
    }).start( );