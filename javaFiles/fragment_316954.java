// Layout Horizontal components 
    layout.setHorizontalGroup(
        layout.createSequentialGroup()
        .addGroup( 
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent( c1 )
            .addComponent( c4 )
        ).addGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent( c2 )
                .addComponent( c5)
        ).addGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent( c3 )
                .addComponent( c6 )
        )

    );

    // Layout vertical components 
    layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addGroup( 
             layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent( c1 )
             .addComponent( c2 )
             .addComponent( c3 )
         ).addGroup(
             layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                 .addComponent( c4 )
                 .addComponent( c5 )
                 .addComponent( c6 ) 
        )
    );

    southPanel.add( panel ); // the start-end dates
    southPanel.add( bookIt, BorderLayout.SOUTH ); // the enter your name...