public Survival() {
        setTitle("Survival");
        setResizable(false);
        setSize(applicationWidth, applicationHeight);
        setVisible(true);
        add(new DrawPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     }

   class DrawPanel extends JPanel
   {
    @Override
    protected  void paintComponent( Graphics g){
       g.drawString("Test", 220,220);
      }
   }