JFrame starsframe = new JFrame();
starsframe.setTitle("Random stars...");
starsframe.setLayout(new GridLayout( 1,2));// Use gridLayout
DrawStar star1 = new DrawStar(300, 200, Color.red);
starsframe.add(star1);
DrawStar star2 = new DrawStar(400, 300, Color.blue);
starsframe.add(star2);

starsframe.setSize(1000,700);// Increase the screen size.
starsframe.setLocationRelativeTo(null);
starsframe.setVisible(true);
starsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);