JPanel displayPanel = new JPanel();
    // JPanel displayPanel = new JPanel( new GridLayout( 4, 2 ) );
    // JPanel displayPanel = new JPanel( new BorderLayout() );
    // JPanel displayPanel = new JPanel( new GridBagLayout() );

    JTextField titleText = new JTextField( "title" );

    titleText.setPreferredSize( new Dimension( 200, 24 ) );

    // For FlowLayout and GridLayout, uncomment:
    displayPanel.add( titleText );

    // For BorderLayout, uncomment:
    // displayPanel.add( titleText, BorderLayout.NORTH );

    // For GridBagLayout, uncomment:
    // displayPanel.add( titleText, new GridBagConstraints( 0, 0, 1, 1, 1.0,
    // 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
    // new Insets( 0, 0, 0, 0 ), 0, 0 ) );