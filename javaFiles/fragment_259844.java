public class BoxesPanel extends JPanel
{
   private boolean drawRect = false, drawCircle = false;
   private int angle = 0;
   private JButton enter; 
   int count = 0;

   //------------------------------------------------------------------
   //   Sets up the drawing panel
   //------------------------------------------------------------------
   public BoxesPanel(int num)
   {
      if(num == 1)
         drawRect = true;
      else if(num == 2)
         drawCircle = true; 

      enter = new JButton("click");
      enter.addActionListener(new ButtonListener());

      add(enter);

      setBackground(Color.gray);
      setPreferredSize(new Dimension(400, 400));
   }

   private class ButtonListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
         System.out.println("Rotate has been clicked: " + count);
         count++;
         angle = (angle + 45)%360;
         repaint();  
      }
   }   

   public void paintComponent(Graphics page)
   {
      super.paintComponent(page);
      Graphics2D g2d = (Graphics2D)page;

      int x, y, width, height;

      x = 100;
      y = 100;

      width = 100;
      height = 100;

      AffineTransform old = g2d.getTransform();

      g2d.rotate(Math.toRadians(angle), x+width/2, y+height/2);

      g2d.setColor(Color.yellow);

      if(drawRect)        
         g2d.fillRect(x,y,width,height);
      else if(drawCircle)
         g2d.fillOval(x,y,width,height);

      g2d.setTransform(old);

      System.out.println("Painted: " + count);
   }
}