JButton b = new JButton( "Click me." );
       ActionListener al = new ActionListener() {
          float value = 42f;
          @Override public void actionPerformed( ActionEvent e ) {
             value += 0.5f;
          }
       };
       b.addActionListener( al );