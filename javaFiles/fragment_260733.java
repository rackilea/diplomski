public Picture() {

      _image1 = new ImageIcon(IMAGE);
      _mainLabel = new JLabel(_image1);
      add(_mainLabel);

      pack(); // to tell the layout managers to set up the GUI
      setLocationRelativeTo(null); // center things
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }