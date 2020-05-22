class Squares extends JPanel {
   private static final long serialVersionUID = 1L;

   public Squares() {
      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);
   }

   private List<Path2D> squares = new ArrayList<Path2D>();
   // private Path2D rect = new Path2D.Double();
   int currentIndex;

   public void addSquare(int x, int y, int width, int height) {
      Path2D rect2 = new Path2D.Double();
      rect2.append(new Rectangle(getWidth() / 2 - width / 2, getHeight() / 2
            - height / 2, width, height), true);

      squares.add(rect2);
      repaint(); // !!
      // rect = rect2;
      // !! MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      // addMouseListener(myMouseAdapter);
      // addMouseMotionListener(myMouseAdapter);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.setOpaque(true);
      this.setBackground(Color.WHITE);
      Graphics2D g2 = (Graphics2D) g;
      for (Path2D rect : squares) {
         g2.draw(rect);
      }
      // !! repaint();