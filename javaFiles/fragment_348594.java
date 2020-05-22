JPanel object = new JPanel ();
    object.addComponentListener ( new ComponentAdapter ()
    {
        public void componentResized ( ComponentEvent e )
        {
            // Your object size changed
        }
    } );

    JScrollPane scrollPane = new JScrollPane ( object );