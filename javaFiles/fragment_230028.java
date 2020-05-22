setTitle( "Tile" );
        setSize( 300, 300 );
        setVisible( true );

        setLayout(new BorderLayout());
        jPanel = new MyOwnJPanel( "My Own JPanel 01" );
        jPanel02 =  new MyOwnJPanel( "My Own JPanel 02" );
        jPanel03 =  new MyOwnJPanel( "My Own JPanel 03" );


        add( jPanel, BorderLayout.CENTER );
        add( jPanel02, BorderLayout.NORTH );
        add(jPanel03, BorderLayout.SOUTH);