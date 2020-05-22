start.addActionListener ( new ActionListener ()
    {
        public void actionPerformed ( ActionEvent e )
        {
            pg.setValue ( 0 );
            pg.setStringPainted ( true );
            new Thread ( new Runnable ()
            {
                public void run ()
                {
                    for ( i = 0; i <= 100; i = i + 1 )
                    {
                        SwingUtilities.invokeLater ( new Runnable ()
                        {
                            public void run ()
                            {
                                pg.setValue ( i );
                            }
                        } );
                        try
                        {
                            java.lang.Thread.sleep ( 100 );
                        }
                        catch ( Exception e )
                        {
                            //
                        }
                    }
                }
            } ).start ();

        }
    } );