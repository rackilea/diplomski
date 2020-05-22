public static void overlapTest() {
        final JPanel p1 = new JPanel();
        final JPanel p2 = new JPanel();
        p1.setBackground(Color.RED);
        p2.setBackground(Color.BLUE);
        final JPanel container = new JPanel();
        container.setLayout(null);
        container.add(p1);
        container.add(p2);
        p1.setBounds(0,0,120,100);
        p2.setBounds(80,0,120,100);
        Dimension size = new Dimension(200,100);
        container.setPreferredSize(size);
        container.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent arg0) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Point pt1 = e.getPoint();
                pt1.translate(-p1.getX(), -p1.getY());
                Point pt2 = e.getPoint(); 
                pt2.translate(-p2.getX(), -p2.getY());
                if (p1.contains(pt1) && p2.contains(pt2)) {
                        System.out.println("both contain: " + e.getPoint());
                        container.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
                  }
                  else{ 
                      container.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                  };
            }

        });
    }