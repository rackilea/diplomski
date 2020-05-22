JFileChooser chooser = new JFileChooser();
    chooser.addPropertyChangeListener( new PropertyChangeListener() {
      public void propertyChange( PropertyChangeEvent evt )
      {
        if ( evt.getPropertyName().equals( "directoryChanged" ) )
        {
          JFileChooser me = (JFileChooser)evt.getSource(); 
          me.setSelectedFile( new File( "text.txt" ) );
        }
      }
    });