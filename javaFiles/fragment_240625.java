private void showSimpleDialog() {
    final JDialog d = new JDialog(this, "Run", true);
    d.setSize(200, 150);
    JLabel l = new JLabel("Pagination Swing Demo", JLabel.CENTER);
    d.getContentPane( ).setLayout(new BorderLayout( ));
    d.getContentPane( ).add(l, BorderLayout.CENTER);
    JButton b = new JButton("Run");
    b.addActionListener(new ActionListener( ) {
       public void actionPerformed(ActionEvent ev) {
          createFrame();
          d.setVisible(false);
          d.dispose( );
         }
      });
    JPanel p = new JPanel( );     // Flow layout will center button.
    p.add(b);
    d.getContentPane( ).add(p, BorderLayout.SOUTH);
    d.setLocationRelativeTo(this);
    d.setVisible(true);
}