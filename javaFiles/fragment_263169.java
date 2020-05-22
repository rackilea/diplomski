public void paintComponent(Graphics g){

       int num_2 = 8;
       int bigOval_h = 300, bigOval_w = 300;

       g.setColor(Color.BLUE);
       g.drawOval(0 + 500, 0, bigOval_h, bigOval_w);
       // REMOVE -------------------------------------------
       // g.drawLine(150+500, 0, 20+500, 225);
       // g.drawLine(150+500, 0, 280+500, 225);
       // g.drawLine(20+500, 225,280+500, 225);
       // REMOVE -------------------------------------------
       g.setColor(Color.RED);

       // ADD -------------------------------------------------------------------
       // Create, transform and draw the lines
       Line2D lin1 = new Line2D.Float(150f + 500f, 0f, 20f + 500f, 225f);
       Line2D lin2 = new Line2D.Float(150f + 500f, 0f, 280f + 500f, 225f);
       Line2D lin3 = new Line2D.Float(20f + 500f, 225f, 280f + 500f, 225f);
       double pivotX = 500.0 + bigOval_w / 2.0; // center of the circle (x)
       double pivotY = 0.0 + bigOval_h / 2.0;   // center of the circle (y)
       for (int i = 0; i < num_2; i++) {
          AffineTransform affineTransform = AffineTransform.getRotateInstance(Math.toRadians(360.0 / num_2 * i), pivotX, pivotY);
          ((Graphics2D)g).draw(affineTransform.createTransformedShape(lin1));
          ((Graphics2D)g).draw(affineTransform.createTransformedShape(lin2));
          ((Graphics2D)g).draw(affineTransform.createTransformedShape(lin3));
       }
       // ADD -------------------------------------------------------------------
   }