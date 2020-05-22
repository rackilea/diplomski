@Override
  public void actionPerformed( ActionEvent e )
  {
     if( timing ) {
        timing = false;
        timer.stop();
        view.setStartButtonText( "start stting" );
        view.setTimerLabel( "stopped" );
        view.setBackground( Color.CYAN.darker() );
     } else {
        nanoTime = System.nanoTime();
        view.setStartButtonText( "stop stting" );
        timing = true;
        timer = new javax.swing.Timer( 1000,
                new ActionListener()
                {
                   @Override
                   public void actionPerformed( ActionEvent e )
                   {
                      long minuteTime = ( System.nanoTime() -
                      nanoTime ) /
                      ( 60_000_000_000L );
                      view.setTimerLabel( minuteTime + " minutes" );
                      if( minuteTime > 50 )
                         if( darkBg ) {
                            view.setBackground( Color.PINK );
                            darkBg = false;
                         } else {
                            view.setBackground( Color.PINK.
                                    darker() );
                            darkBg = true;
                         }
                   }
                } );
        timer.setRepeats( true );
        timer.start();
     }
  }